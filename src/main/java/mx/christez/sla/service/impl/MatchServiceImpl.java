package mx.christez.sla.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.Cluster;
import mx.christez.sla.entity.Match;
import mx.christez.sla.entity.Playoff;
import mx.christez.sla.entity.Schedule;
import mx.christez.sla.entity.Team;
import mx.christez.sla.entity.Tournament;
import mx.christez.sla.exception.NoMatchFoundException;
import mx.christez.sla.repository.ClusterRepository;
import mx.christez.sla.repository.MatchRepository;
import mx.christez.sla.repository.PlayoffRepository;
import mx.christez.sla.repository.TeamRepository;
import mx.christez.sla.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {
	@Autowired
	private ClusterRepository clusterRepository;
	
	@Autowired
	private MatchRepository matchRepository;
	
	@Autowired
	private PlayoffRepository playoffRepository;
	
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Object findOne(int matchId) throws NoMatchFoundException {
		Match match = matchRepository.findOne(matchId);
		
		if(match == null)
			throw new NoMatchFoundException();
		
		return match;
	}

	@Override
	@Transactional
	public void update(int matchId, Match match) {
		Match originalMatch = matchRepository.findOne(matchId);
		originalMatch.setDate(match.getDate());
		originalMatch.setGoalsLocal(match.getGoalsLocal());
		originalMatch.setGoalsVisitor(match.getGoalsVisitor());
		originalMatch.setTime(match.getTime());
		originalMatch.setStatus(match.getStatus());
		
		if(match.getStatus().equals("Jugado")) {
			Tournament tournament = null;
			
			if(originalMatch.getSchedule() == null) {				
				Playoff playoff = originalMatch.getPlayoff();
				playoff.setGamesPlayed(playoff.getGamesPlayed() + 1);
				
				tournament = originalMatch.getPlayoff().getTournament();
			}else {
				Schedule schedule = originalMatch.getSchedule();
				schedule.setGamesPlayed(schedule.getGamesPlayed() + 1);
				
				if(originalMatch.getSchedule().getTournament() == null)
					tournament = originalMatch.getSchedule().getCluster().getTournament();
				else
					tournament = originalMatch.getSchedule().getTournament();
			}
			
			if(tournament.getStatus().equals("Puntos")) {
				tournament.setGamesPlayed(tournament.getGamesPlayed() + 1);
			
				Team teamLocal = teamRepository.findOne(originalMatch.getTeamLocalId());
				Team teamVisitor = teamRepository.findOne(originalMatch.getTeamVisitorId());
				
				teamLocal.setGamesPlayed(teamLocal.getGamesPlayed() + 1);
				teamLocal.setGoalsFavor(teamLocal.getGoalsFavor() + match.getGoalsLocal());
				teamLocal.setGoalsAgainst(teamLocal.getGoalsAgainst() + match.getGoalsVisitor());
				teamLocal.setGoalsDifference(teamLocal.getGoalsFavor() - teamLocal.getGoalsAgainst());
				
				teamVisitor.setGamesPlayed(teamVisitor.getGamesPlayed() + 1);
				teamVisitor.setGoalsFavor(teamVisitor.getGoalsFavor() + match.getGoalsVisitor());
				teamVisitor.setGoalsAgainst(teamVisitor.getGoalsAgainst() + match.getGoalsLocal());
				teamVisitor.setGoalsDifference(teamVisitor.getGoalsFavor() - teamVisitor.getGoalsAgainst());
				
				if(match.getGoalsLocal() == match.getGoalsVisitor()) {
					teamLocal.setGamesDrawed(teamLocal.getGamesDrawed() + 1);
					teamLocal.setPoints(teamLocal.getPoints() + 1);
					
					teamVisitor.setGamesDrawed(teamVisitor.getGamesDrawed() + 1);
					teamVisitor.setPoints(teamVisitor.getPoints() + 1);
				}else if(match.getGoalsLocal() > match.getGoalsVisitor()) {
					teamLocal.setGamesWon(teamLocal.getGamesWon() + 1);
					teamLocal.setPoints(teamLocal.getPoints() + 3);
					
					teamVisitor.setGamesLost(teamVisitor.getGamesLost() + 1);
				}else {
					teamLocal.setGamesLost(teamLocal.getGamesLost() + 1);
									
					teamVisitor.setGamesWon(teamVisitor.getGamesWon() + 1);
					teamVisitor.setPoints(teamVisitor.getPoints() + 3);
				}
			}
			
			if(tournament.getGamesProgrammed() == tournament.getGamesPlayed()){
				if(tournament.getType().equals("Por puntos"))
					if(tournament.getStatus().equals("Puntos")) {
						List<Team> teams = teamRepository.findByTournamentOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(tournament);
						tournament.setWinner(teams.get(0).getName());
						tournament.setStatus("Finalizado");		
					}
				
				if(tournament.getType().equals("Por puntos más liguilla")) {
					if(tournament.getStatus().equals("Puntos")) {
						tournament.setStatus("Liguilla");
					
						List<Playoff> playoffs = playoffRepository.findByTournamentOrderByIdAsc(tournament);
						Playoff playoff = playoffs.get(0);
						List<Team> teams = teamRepository.findByTournamentOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(tournament);
						
						int numberOfClassified = tournament.getNumberClassified();
						int numberOfMatches = numberOfClassified / 2;
						
						for(int counter = 0; counter < numberOfMatches; counter++){
							playoff.getMatches().get(counter).setTeamLocalId(teams.get(counter).getId());
							playoff.getMatches().get(counter).setTeamLocalName(teams.get(counter).getName());
							playoff.getMatches().get(counter).setTeamVisitorId(teams.get(numberOfClassified - counter -1).getId());
							playoff.getMatches().get(counter).setTeamVisitorName(teams.get(numberOfClassified - counter -1).getName());
						}
						
						playoff.setStatus("Programado");
					}else {
						List<Playoff> playoffs = playoffRepository.findByTournamentOrderByIdAsc(tournament);
						List<Team> teams = teamRepository.findByTournamentOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(tournament);
						
						for(int counter = 0; counter < playoffs.size(); counter++){
							if(playoffs.get(counter).getStatus().equals("Programado")){
								List<Match> matches = playoffs.get(counter).getMatches();
								int numberOfMatches = matches.size();
								int numberOfPlayedMatches = 0;
								List<String> winningTeams = new ArrayList<String>();
								
								for(int innerCounter = 0; innerCounter < numberOfMatches; innerCounter++) {
									if(matches.get(innerCounter).getStatus().equals("Jugado"))
										numberOfPlayedMatches++;
									
									if(matches.get(innerCounter).getGoalsLocal() == matches.get(innerCounter).getGoalsVisitor()) {
										String winningTeam = findWinningTeamByTablePosition(teams, matches.get(innerCounter).getTeamLocalId(), matches.get(innerCounter).getTeamLocalName(), matches.get(innerCounter).getTeamVisitorId(), matches.get(innerCounter).getTeamVisitorName());
										matches.get(innerCounter).setWinner(winningTeam);
										winningTeams.add(winningTeam);
									}else {
										if(matches.get(innerCounter).getGoalsLocal() > matches.get(innerCounter).getGoalsVisitor()) {
											matches.get(innerCounter).setWinner(matches.get(innerCounter).getTeamLocalName());
											winningTeams.add(matches.get(innerCounter).getTeamLocalId() + "|" + matches.get(innerCounter).getTeamLocalName());
										}else {
											matches.get(innerCounter).setWinner(matches.get(innerCounter).getTeamVisitorName());
											winningTeams.add(matches.get(innerCounter).getTeamVisitorId() + "|" + matches.get(innerCounter).getTeamVisitorName());
										}
									}
								}
								
								if(numberOfPlayedMatches == numberOfMatches) {
									playoffs.get(counter).setStatus("Concluido");
									
									if(playoffs.size() > 1 && counter < playoffs.size() - 1) {
										playoffs.get(counter + 1).setStatus("Programado");
									
										List<String> sortedWinningTeams = sortWinningTeams(teams, winningTeams);
										List<Match> nextMatches = playoffs.get(counter + 1).getMatches();
										
										for(int counterMatches = 0; counterMatches < nextMatches.size(); counterMatches++){
											nextMatches.get(counterMatches).setTeamLocalId(Integer.parseInt(sortedWinningTeams.get(counterMatches).split("\\|")[0]));
											nextMatches.get(counterMatches).setTeamLocalName(sortedWinningTeams.get(counterMatches).split("\\|")[1]);
											nextMatches.get(counterMatches).setTeamVisitorId(Integer.parseInt(sortedWinningTeams.get(sortedWinningTeams.size() - counterMatches - 1).split("\\|")[0]));
											nextMatches.get(counterMatches).setTeamVisitorName(sortedWinningTeams.get(sortedWinningTeams.size() - counterMatches - 1).split("\\|")[1]);
										}
									}else{
										tournament.setWinner(playoffs.get(playoffs.size() - 1).getMatches().get(0).getWinner());
										tournament.setStatus("Finalizado");
									}
								}
								
								break;
							}
						}
					}
				}
				
				if(tournament.getType().equals("Por grupos más liguilla")) {
					if(tournament.getStatus().equals("Puntos")) {
						tournament.setStatus("Liguilla");
					
						List<Playoff> playoffs = playoffRepository.findByTournamentOrderByIdAsc(tournament);
						Playoff playoff = playoffs.get(0);
						List<Team> teams = getClassifiedTeams(tournament);
						
						int numberOfClassified = tournament.getNumberClassified();
						int numberOfMatches = numberOfClassified / 2;
						
						for(int counter = 0; counter < numberOfMatches; counter++){
							playoff.getMatches().get(counter).setTeamLocalId(teams.get(counter).getId());
							playoff.getMatches().get(counter).setTeamLocalName(teams.get(counter).getName());
							playoff.getMatches().get(counter).setTeamVisitorId(teams.get(numberOfClassified - counter -1).getId());
							playoff.getMatches().get(counter).setTeamVisitorName(teams.get(numberOfClassified - counter -1).getName());
						}
						
						playoff.setStatus("Programado");
					}else {
						List<Playoff> playoffs = playoffRepository.findByTournamentOrderByIdAsc(tournament);
						List<Team> teams = getClassifiedTeams(tournament);
						
						for(int counter = 0; counter < playoffs.size(); counter++){
							if(playoffs.get(counter).getStatus().equals("Programado")){
								List<Match> matches = playoffs.get(counter).getMatches();
								int numberOfMatches = matches.size();
								int numberOfPlayedMatches = 0;
								List<String> winningTeams = new ArrayList<String>();
								
								for(int innerCounter = 0; innerCounter < numberOfMatches; innerCounter++) {
									if(matches.get(innerCounter).getStatus().equals("Jugado"))
										numberOfPlayedMatches++;
									
									if(matches.get(innerCounter).getGoalsLocal() == matches.get(innerCounter).getGoalsVisitor()) {
										String winningTeam = findWinningTeamByClusterTablePosition(teams, matches.get(innerCounter).getTeamLocalId(), matches.get(innerCounter).getTeamLocalName(), matches.get(innerCounter).getTeamVisitorId(), matches.get(innerCounter).getTeamVisitorName());
										matches.get(innerCounter).setWinner(winningTeam);
										winningTeams.add(winningTeam);
									}else {
										if(matches.get(innerCounter).getGoalsLocal() > matches.get(innerCounter).getGoalsVisitor()) {
											matches.get(innerCounter).setWinner(matches.get(innerCounter).getTeamLocalName());
											winningTeams.add(matches.get(innerCounter).getTeamLocalId() + "|" + matches.get(innerCounter).getTeamLocalName());
										}else {
											matches.get(innerCounter).setWinner(matches.get(innerCounter).getTeamVisitorName());
											winningTeams.add(matches.get(innerCounter).getTeamVisitorId() + "|" + matches.get(innerCounter).getTeamVisitorName());
										}
									}
									
								}
								
								if(numberOfPlayedMatches == numberOfMatches) {
									playoffs.get(counter).setStatus("Concluido");
									
									if(playoffs.size() > 1 && counter < playoffs.size() - 1) {
										playoffs.get(counter + 1).setStatus("Programado");
									
										List<String> sortedWinningTeams = sortWinningTeams(teams, winningTeams);
										List<Match> nextMatches = playoffs.get(counter + 1).getMatches();
										
										for(int counterMatches = 0; counterMatches < nextMatches.size(); counterMatches++){
											nextMatches.get(counterMatches).setTeamLocalId(Integer.parseInt(sortedWinningTeams.get(counterMatches).split("\\|")[0]));
											nextMatches.get(counterMatches).setTeamLocalName(sortedWinningTeams.get(counterMatches).split("\\|")[1]);
											nextMatches.get(counterMatches).setTeamVisitorId(Integer.parseInt(sortedWinningTeams.get(sortedWinningTeams.size() - counterMatches - 1).split("\\|")[0]));
											nextMatches.get(counterMatches).setTeamVisitorName(sortedWinningTeams.get(sortedWinningTeams.size() - counterMatches - 1).split("\\|")[1]);
										}
									}else{
										tournament.setWinner(playoffs.get(playoffs.size() - 1).getMatches().get(0).getWinner());
										tournament.setStatus("Finalizado");
									}
								}
								
								break;
							}
						}
					}
				}
				
				if(tournament.getType().equals("Por liguilla")) {
					List<Playoff> playoffs = playoffRepository.findByTournamentOrderByIdAsc(tournament);
					List<Team> teams = teamRepository.findByTournamentOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(tournament);
					
					for(int counter = 0; counter < playoffs.size(); counter++){
						if(playoffs.get(counter).getStatus().equals("Programado")){
							List<Match> matches = playoffs.get(counter).getMatches();
							int numberOfMatches = matches.size();
							int numberOfPlayedMatches = 0;
							List<String> winningTeams = new ArrayList<String>();
							
							for(int innerCounter = 0; innerCounter < numberOfMatches; innerCounter++) {
								if(matches.get(innerCounter).getStatus().equals("Jugado"))
									numberOfPlayedMatches++;
								
								if(matches.get(innerCounter).getGoalsLocal() == matches.get(innerCounter).getGoalsVisitor()) {
									String winningTeam = findWinningTeamByTablePosition(teams, matches.get(innerCounter).getTeamLocalId(), matches.get(innerCounter).getTeamLocalName(), matches.get(innerCounter).getTeamVisitorId(), matches.get(innerCounter).getTeamVisitorName());
									matches.get(innerCounter).setWinner(winningTeam);
									winningTeams.add(winningTeam);
								}else {
									if(matches.get(innerCounter).getGoalsLocal() > matches.get(innerCounter).getGoalsVisitor()) {
										matches.get(innerCounter).setWinner(matches.get(innerCounter).getTeamLocalName());
										winningTeams.add(matches.get(innerCounter).getTeamLocalId() + "|" + matches.get(innerCounter).getTeamLocalName());
									}else {
										matches.get(innerCounter).setWinner(matches.get(innerCounter).getTeamVisitorName());
										winningTeams.add(matches.get(innerCounter).getTeamVisitorId() + "|" + matches.get(innerCounter).getTeamVisitorName());
									}
								}
							}
							
							if(numberOfPlayedMatches == numberOfMatches) {
								playoffs.get(counter).setStatus("Concluido");
								
								if(playoffs.size() > 1 && counter < playoffs.size() - 1) {
									playoffs.get(counter + 1).setStatus("Programado");
								
									List<String> sortedWinningTeams = sortWinningTeams(teams, winningTeams);
									List<Match> nextMatches = playoffs.get(counter + 1).getMatches();
									
									for(int counterMatches = 0; counterMatches < nextMatches.size(); counterMatches++){
										nextMatches.get(counterMatches).setTeamLocalId(Integer.parseInt(sortedWinningTeams.get(counterMatches).split("\\|")[0]));
										nextMatches.get(counterMatches).setTeamLocalName(sortedWinningTeams.get(counterMatches).split("\\|")[1]);
										nextMatches.get(counterMatches).setTeamVisitorId(Integer.parseInt(sortedWinningTeams.get(sortedWinningTeams.size() - counterMatches - 1).split("\\|")[0]));
										nextMatches.get(counterMatches).setTeamVisitorName(sortedWinningTeams.get(sortedWinningTeams.size() - counterMatches - 1).split("\\|")[1]);
									}
								}else{
									tournament.setWinner(playoffs.get(playoffs.size() - 1).getMatches().get(0).getWinner());
									tournament.setStatus("Finalizado");
								}
							}
							
							break;
						}
					}
				}
			}
		}
	}
	
	private String findWinningTeamByTablePosition(List<Team> teams, int localId, String localName, int visitorId, String visitorName) {
		String winningTeam = "";
		
		for(Team team: teams)
			if(team.getId() == localId) {
				winningTeam = localId + "|" + localName;
				break;
			}else
				if(team.getId() == visitorId) {
					winningTeam = visitorId + "|" + visitorName;
					break;
				}
		
		return winningTeam;
	}
	
	private String findWinningTeamByClusterTablePosition(List<Team> teams, int localId, String localName, int visitorId, String visitorName) {
		String winningTeam = "";
		Team localTeam = null;
		Team visitorTeam = null;
		
		for(Team team: teams)
			if(team.getId() == localId) {
				localTeam = team;
				continue;
			}else
				if(team.getId() == visitorId) {
					visitorTeam = team;
					continue;
				}
		
		if(localTeam.getPoints() == visitorTeam.getPoints()) {
			if(localTeam.getGoalsDifference() == visitorTeam.getGoalsDifference()) {
				if(localTeam.getGoalsFavor() == visitorTeam.getGoalsFavor()) {
					if(localTeam.getId() < visitorTeam.getId()) {
						winningTeam = localId + "|" + localName;
					}else {
						winningTeam = visitorId + "|" + visitorName;
					}
				}else {
					if(localTeam.getGoalsFavor() > visitorTeam.getGoalsFavor())
						winningTeam = localId + "|" + localName;
					else
						winningTeam = visitorId + "|" + visitorName;
				}
			}else {
				if(localTeam.getGoalsDifference() > visitorTeam.getGoalsDifference())
					winningTeam = localId + "|" + localName;
				else
					winningTeam = visitorId + "|" + visitorName;
			}
		}else {
			if(localTeam.getPoints() > visitorTeam.getPoints())
				winningTeam = localId + "|" + localName;
			else
				winningTeam = visitorId + "|" + visitorName;
		}
		
		return winningTeam;
	}
	
	private List<String> sortWinningTeams(List<Team> teams, List<String> winningTeams){		
		List<String> sortedWinningTeams = new ArrayList<String>();
		
		for(Team team: teams)
			for(String winningTeam: winningTeams) {
				int id = Integer.parseInt(winningTeam.split("\\|")[0]);
				
				if(id == team.getId())
					sortedWinningTeams.add(winningTeam);
			}
		
		return sortedWinningTeams;
	}
	
	private List<Team> getClassifiedTeams(Tournament tournament){
		List<Team> teams = new ArrayList<Team>();
		List<Cluster> clusters = clusterRepository.findByTournamentOrderByIdAsc(tournament);
		
		if(tournament.getSelection().equals("El mejor de cada grupo"))
			for(Cluster cluster: clusters)
				teams.add(teamRepository.findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(cluster).get(0));
				
		if(tournament.getSelection().equals("Los dos mejores de cada grupo")) 
			for(Cluster cluster: clusters) {
				teams.add(teamRepository.findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(cluster).get(0));
				teams.add(teamRepository.findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(cluster).get(1));
			}
		
		if(tournament.getSelection().equals("Los cuatro mejores de cada grupo"))
			for(Cluster cluster: clusters) {
				teams.add(teamRepository.findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(cluster).get(0));
				teams.add(teamRepository.findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(cluster).get(1));
				teams.add(teamRepository.findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(cluster).get(2));
				teams.add(teamRepository.findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(cluster).get(3));
			}
		
		return teams;
	}
}

package mx.christez.sla.service.impl;

import java.time.LocalDateTime;
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
import mx.christez.sla.exception.NoTeamsFoundException;
import mx.christez.sla.exception.NotEnoughClustersFoundException;
import mx.christez.sla.exception.IncorrectNumberOfClustersException;
import mx.christez.sla.exception.NotEnoughTeamsFoundException;
import mx.christez.sla.repository.ClusterRepository;
import mx.christez.sla.repository.MatchRepository;
import mx.christez.sla.repository.PlayoffRepository;
import mx.christez.sla.repository.ScheduleRepository;
import mx.christez.sla.repository.TeamRepository;
import mx.christez.sla.repository.TournamentRepository;
import mx.christez.sla.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ClusterRepository clusterRepository;
	
	@Autowired
	private MatchRepository matchRepository;
	
	@Autowired
	private PlayoffRepository playoffRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TournamentRepository tournamentRepository;

	@Override
	@Transactional
	public void generateSchedulePoints(int tournamentId, Tournament tournamentAux, String params) throws NoTeamsFoundException, NotEnoughTeamsFoundException {
		Tournament tournament = tournamentRepository.findOne(tournamentId);
		List<Team> teams = teamRepository.findByTournament(tournament);
		
		if(teams == null)
			throw new NoTeamsFoundException();
		
		if(teams.size() < 2)
			throw new NotEnoughTeamsFoundException("Equipos no suficientes para generar las jornadas");
		
		if(params.equals("pointsPlayoffs") && teams.size() < tournamentAux.getNumberClassified())
			throw new NotEnoughTeamsFoundException("Equipos no suficientes para generar la liguilla");
		
		if(teams.size() % 2 == 1) {
			Team restTeam = new Team();
			restTeam.setName("Descansa");
			
			teams.add(restTeam);
		}
		
		int numberOfSchedules = teams.size() - 1;
		int halfSize = teams.size() / 2;
		int gameCounter = 0;
		
		List<Team> teamsAux = new ArrayList<Team>();

		for(Team team: teams)
			teamsAux.add(team);

		teamsAux.remove(0);

		int teamsSize = teamsAux.size();
		
		for (int scheduleCounter = 0; scheduleCounter < numberOfSchedules; scheduleCounter++) {
			Schedule schedule = new Schedule();
			schedule.setTournament(tournament);
			int numberOfGames = 0;
			
			int teamIdx = scheduleCounter % teamsSize;

			if(teams.get(0).getName().equals("Descansa") || teamsAux.get(teamIdx).getName().equals("Descansa")) {
				if(teams.get(0).getName().equals("Descansa"))
					schedule.setRestingTeam(teamsAux.get(teamIdx).getName());
				else
					schedule.setRestingTeam(teams.get(0).getName());
			}else {
				Match match = new Match();
				match.setSchedule(schedule);
				match.setTeamLocalId(teams.get(0).getId());
				match.setTeamLocalName(teams.get(0).getName());
				match.setTeamVisitorId(teamsAux.get(teamIdx).getId());
				match.setTeamVisitorName(teamsAux.get(teamIdx).getName());
				match.setStatus("No jugado");
				
				LocalDateTime now = LocalDateTime.now();
				match.setDate(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
				match.setTime(now.getHour() + ":" + now.getMinute());
				
				matchRepository.save(match);
				gameCounter++;
				numberOfGames++;
			}

			for (int idx = 1; idx < halfSize; idx++) {
				int firstTeam = (scheduleCounter + idx) % teamsSize;
				int secondTeam = (scheduleCounter + teamsSize - idx) % teamsSize;
				
				if(teamsAux.get(firstTeam).getName().equals("Descansa") || teamsAux.get(secondTeam).getName().equals("Descansa")) {
					if(teams.get(firstTeam).getName().equals("Descansa"))
						schedule.setRestingTeam(teamsAux.get(secondTeam).getName());
					else
						schedule.setRestingTeam(teamsAux.get(firstTeam).getName());
				}else {
					Match match = new Match();
					match.setSchedule(schedule);
					match.setTeamLocalId(teamsAux.get(firstTeam).getId());
					match.setTeamLocalName(teamsAux.get(firstTeam).getName());
					match.setTeamVisitorId(teamsAux.get(secondTeam).getId());
					match.setTeamVisitorName(teamsAux.get(secondTeam).getName());
					match.setStatus("No jugado");
					
					LocalDateTime now = LocalDateTime.now();
					match.setDate(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
					match.setTime(now.getHour() + ":" + now.getMinute());
					
					matchRepository.save(match);
					gameCounter++;
					numberOfGames++;
				}
			}
			
			if(schedule.getRestingTeam() == null)
				schedule.setRestingTeam("Ninguno");
			
			schedule.setGamesProgrammed(numberOfGames);
			scheduleRepository.save(schedule);
		}
		
		if(tournamentAux.getSchema().equals("Dos vueltas"))
			for (int scheduleCounter = 0; scheduleCounter < numberOfSchedules; scheduleCounter++) {
				Schedule schedule = new Schedule();
				schedule.setTournament(tournament);
				int numberOfGames = 0;
				
				int teamIdx = scheduleCounter % teamsSize;

				if(teams.get(0).getName().equals("Descansa") || teamsAux.get(teamIdx).getName().equals("Descansa")) {
					if(teams.get(0).getName().equals("Descansa"))
						schedule.setRestingTeam(teamsAux.get(teamIdx).getName());
					else
						schedule.setRestingTeam(teams.get(0).getName());
				}else {
					Match match = new Match();
					match.setSchedule(schedule);
					match.setTeamLocalId(teamsAux.get(teamIdx).getId());
					match.setTeamLocalName(teamsAux.get(teamIdx).getName());
					match.setTeamVisitorId(teams.get(0).getId());
					match.setTeamVisitorName(teams.get(0).getName());
					match.setStatus("No jugado");
					
					LocalDateTime now = LocalDateTime.now();
					match.setDate(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
					match.setTime(now.getHour() + ":" + now.getMinute());
					
					matchRepository.save(match);
					gameCounter++;
					numberOfGames++;
				}

				for (int idx = 1; idx < halfSize; idx++) {
					int firstTeam = (scheduleCounter + idx) % teamsSize;
					int secondTeam = (scheduleCounter + teamsSize - idx) % teamsSize;
					
					if(teamsAux.get(firstTeam).getName().equals("Descansa") || teamsAux.get(secondTeam).getName().equals("Descansa")) {
						if(teams.get(firstTeam).getName().equals("Descansa"))
							schedule.setRestingTeam(teamsAux.get(secondTeam).getName());
						else
							schedule.setRestingTeam(teamsAux.get(firstTeam).getName());
					}else {
						Match match = new Match();
						match.setSchedule(schedule);
						match.setTeamLocalId(teamsAux.get(secondTeam).getId());
						match.setTeamLocalName(teamsAux.get(secondTeam).getName());
						match.setTeamVisitorId(teamsAux.get(firstTeam).getId());
						match.setTeamVisitorName(teamsAux.get(firstTeam).getName());
						match.setStatus("No jugado");
						
						LocalDateTime now = LocalDateTime.now();
						match.setDate(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
						match.setTime(now.getHour() + ":" + now.getMinute());
						
						matchRepository.save(match);
						gameCounter++;
						numberOfGames++;
					}
				}
				
				if(schedule.getRestingTeam() == null)
					schedule.setRestingTeam("Ninguno");
				
				schedule.setGamesProgrammed(numberOfGames);
				scheduleRepository.save(schedule);
			}
		
		if(params.equals("pointsPlayoffs")) {
			int numberofSchedules = 0;
			int numberOfClassified = tournamentAux.getNumberClassified();
			
			switch(numberOfClassified) {
				case 2:
					numberofSchedules = 1;
					break;
				case 4:
					numberofSchedules = 2;
					break;
				case 8:
					numberofSchedules = 3;
					break;
				case 16:
					numberofSchedules = 4;
					break;
				case 32:
					numberofSchedules = 5;
					break;
				default:
					throw new NotEnoughTeamsFoundException("Equipos no suficientes para generar la liguilla");
			}
			
			for(int counter = 0; counter < numberofSchedules; counter++) {
				Playoff playoff = new Playoff();
				playoff.setTournament(tournament);
				playoff.setStatus("Pendiente");
				
				int numberOfMatches = numberOfClassified / 2;
				int numberOfGames = 0;
				
				for(int counterMatches = 0; counterMatches < numberOfMatches; counterMatches++) {
					Match match = new Match();
					match.setPlayoff(playoff);
					match.setTeamLocalId(0);
					match.setTeamLocalName("Indefinido");
					match.setTeamVisitorId(0);
					match.setTeamVisitorName("Indefinido");
					match.setStatus("No jugado");
					
					LocalDateTime now = LocalDateTime.now();
					match.setDate(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
					match.setTime(now.getHour() + ":" + now.getMinute());
					
					matchRepository.save(match);
					numberOfGames++;
				}
				
				numberOfClassified /= 2;
				
				playoff.setGamesProgrammed(numberOfGames);
				playoffRepository.save(playoff);
			}
		}
		
		tournament.setNumberClassified(tournamentAux.getNumberClassified());
		tournament.setSchema(tournamentAux.getSchema());
		tournament.setScheduleGenerated(true);
		tournament.setStatus("Puntos");
		tournament.setGamesProgrammed(gameCounter);
		tournament.setGamesPlayed(0);
	}

	@Override
	@Transactional
	public void generateScheduleGroups(int tournamentId, Tournament tournamentAux) throws NotEnoughClustersFoundException, IncorrectNumberOfClustersException, NoTeamsFoundException, NotEnoughTeamsFoundException {
		Tournament tournament = tournamentRepository.findOne(tournamentId);
		List<Cluster> clusters = clusterRepository.findByTournamentOrderByIdAsc(tournament);
		int numberOfClassified = 0;
		int numberofSchedules = 0;
		
		for(Cluster cluster: clusters) {
			List<Team> teams = teamRepository.findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(cluster);
			
			cluster.setTeams(teams);
		}
		
		if(clusters.size() < 2)
			throw new NotEnoughClustersFoundException("Grupos no suficientes para generar las jornadas. Se requieren al menos dos grupos para proceder");
		
		if(tournamentAux.getSelection().equals("El mejor de cada grupo")) {
			for(Cluster cluster: clusters)
				if(cluster.getTeams().size() < 2)
					throw new NotEnoughTeamsFoundException("El grupo \"" + cluster.getName() + "\" no cuenta con los equipos suficientes para generar las jornadas");
			
			numberOfClassified = clusters.size();
			
			switch(numberOfClassified) {
				case 2:
					numberofSchedules = 1;
					break;
				case 4:
					numberofSchedules = 2;
					break;
				case 8:
					numberofSchedules = 3;
					break;
				case 16:
					numberofSchedules = 4;
					break;
				case 32:
					numberofSchedules = 5;
					break;
				default:
					throw new IncorrectNumberOfClustersException("Número de grupos incorrecto para generar la liguilla. Debes tener 2, 4, 8, 16 o 32 grupos creados");
			}
		}
		
		if(tournamentAux.getSelection().equals("Los dos mejores de cada grupo")) {
			for(Cluster cluster: clusters)
				if(cluster.getTeams().size() < 2)
					throw new NotEnoughTeamsFoundException("El grupo \"" + cluster.getName() + "\" no cuenta con los equipos suficientes para generar las jornadas");
			
			numberOfClassified = clusters.size() * 2;
			
			switch(numberOfClassified) {
				case 4:
					numberofSchedules = 2;
					break;
				case 8:
					numberofSchedules = 3;
					break;
				case 16:
					numberofSchedules = 4;
					break;
				case 32:
					numberofSchedules = 5;
					break;
				default:
					throw new IncorrectNumberOfClustersException("Número de grupos incorrecto para generar la liguilla. Debes tener 2, 4, 8 o 16 grupos creados");
			}
		}
		
		if(tournamentAux.getSelection().equals("Los cuatro mejores de cada grupo")) {
			for(Cluster cluster: clusters)
				if(cluster.getTeams().size() < 4)
					throw new NotEnoughTeamsFoundException("El grupo \"" + cluster.getName() + "\" no cuenta con los equipos suficientes para generar las jornadas");
			
			numberOfClassified = clusters.size() * 4;
			
			switch(numberOfClassified) {
				case 8:
					numberofSchedules = 3;
					break;
				case 16:
					numberofSchedules = 4;
					break;
				case 32:
					numberofSchedules = 5;
					break;
				default:
					throw new IncorrectNumberOfClustersException("Número de grupos incorrecto para generar la liguilla. Debes tener 2, 4 u 8 grupos creados");
			}
		}
		
		int gameCounter = 0;
		
		for(Cluster cluster: clusters) {
			if(cluster.getTeams().size() % 2 == 1) {
				Team restTeam = new Team();
				restTeam.setName("Descansa");
				
				cluster.getTeams().add(restTeam);
			}
			
			int numberOfSchedules = cluster.getTeams().size() - 1;
			int halfSize = cluster.getTeams().size() / 2;
			
			List<Team> teamsAux = new ArrayList<Team>();

			for(Team team: cluster.getTeams())
				teamsAux.add(team);
			
			teamsAux.remove(0);
			int teamsSize = teamsAux.size();
			
			for (int scheduleCounter = 0; scheduleCounter < numberOfSchedules; scheduleCounter++) {
				Schedule schedule = new Schedule();
				schedule.setCluster(cluster);
				scheduleRepository.save(schedule);
				
				int numberOfGames = 0;
				
				int teamIdx = scheduleCounter % teamsSize;

				if(cluster.getTeams().get(0).getName().equals("Descansa") || teamsAux.get(teamIdx).getName().equals("Descansa")) {
					if(cluster.getTeams().get(0).getName().equals("Descansa"))
						schedule.setRestingTeam(teamsAux.get(teamIdx).getName());
					else
						schedule.setRestingTeam(cluster.getTeams().get(0).getName());
				}else {
					Match match = new Match();
					match.setSchedule(schedule);
					match.setTeamLocalId(cluster.getTeams().get(0).getId());
					match.setTeamLocalName(cluster.getTeams().get(0).getName());
					match.setTeamVisitorId(teamsAux.get(teamIdx).getId());
					match.setTeamVisitorName(teamsAux.get(teamIdx).getName());
					match.setStatus("No jugado");
					
					LocalDateTime now = LocalDateTime.now();
					match.setDate(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
					match.setTime(now.getHour() + ":" + now.getMinute());
					
					matchRepository.save(match);
					gameCounter++;
					numberOfGames++;
				}

				for (int idx = 1; idx < halfSize; idx++) {
					int firstTeam = (scheduleCounter + idx) % teamsSize;
					int secondTeam = (scheduleCounter + teamsSize - idx) % teamsSize;
					
					if(teamsAux.get(firstTeam).getName().equals("Descansa") || teamsAux.get(secondTeam).getName().equals("Descansa")) {
						if(cluster.getTeams().get(firstTeam).getName().equals("Descansa"))
							schedule.setRestingTeam(teamsAux.get(secondTeam).getName());
						else
							schedule.setRestingTeam(teamsAux.get(firstTeam).getName());
					}else {
						Match match = new Match();
						match.setSchedule(schedule);
						match.setTeamLocalId(teamsAux.get(firstTeam).getId());
						match.setTeamLocalName(teamsAux.get(firstTeam).getName());
						match.setTeamVisitorId(teamsAux.get(secondTeam).getId());
						match.setTeamVisitorName(teamsAux.get(secondTeam).getName());
						match.setStatus("No jugado");
						
						LocalDateTime now = LocalDateTime.now();
						match.setDate(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
						match.setTime(now.getHour() + ":" + now.getMinute());
						
						matchRepository.save(match);
						gameCounter++;
						numberOfGames++;
					}
				}
				
				if(schedule.getRestingTeam() == null)
					schedule.setRestingTeam("Ninguno");
				
				schedule.setGamesProgrammed(numberOfGames);
			}
			
			if(tournamentAux.getSchema().equals("Dos vueltas"))
				for (int scheduleCounter = 0; scheduleCounter < numberOfSchedules; scheduleCounter++) {
					Schedule schedule = new Schedule();
					schedule.setCluster(cluster);
					scheduleRepository.save(schedule);
					
					int numberOfGames = 0;
					
					int teamIdx = scheduleCounter % teamsSize;

					if(cluster.getTeams().get(0).getName().equals("Descansa") || teamsAux.get(teamIdx).getName().equals("Descansa")) {
						if(cluster.getTeams().get(0).getName().equals("Descansa"))
							schedule.setRestingTeam(teamsAux.get(teamIdx).getName());
						else
							schedule.setRestingTeam(cluster.getTeams().get(0).getName());
					}else {
						Match match = new Match();
						match.setSchedule(schedule);
						match.setTeamLocalId(teamsAux.get(teamIdx).getId());
						match.setTeamLocalName(teamsAux.get(teamIdx).getName());
						match.setTeamVisitorId(cluster.getTeams().get(0).getId());
						match.setTeamVisitorName(cluster.getTeams().get(0).getName());
						match.setStatus("No jugado");
						
						LocalDateTime now = LocalDateTime.now();
						match.setDate(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
						match.setTime(now.getHour() + ":" + now.getMinute());
						
						matchRepository.save(match);
						gameCounter++;
						numberOfGames++;
					}

					for (int idx = 1; idx < halfSize; idx++) {
						int firstTeam = (scheduleCounter + idx) % teamsSize;
						int secondTeam = (scheduleCounter + teamsSize - idx) % teamsSize;
						
						if(teamsAux.get(firstTeam).getName().equals("Descansa") || teamsAux.get(secondTeam).getName().equals("Descansa")) {
							if(cluster.getTeams().get(firstTeam).getName().equals("Descansa"))
								schedule.setRestingTeam(teamsAux.get(secondTeam).getName());
							else
								schedule.setRestingTeam(teamsAux.get(firstTeam).getName());
						}else {
							Match match = new Match();
							match.setSchedule(schedule);
							match.setTeamLocalId(teamsAux.get(secondTeam).getId());
							match.setTeamLocalName(teamsAux.get(secondTeam).getName());
							match.setTeamVisitorId(teamsAux.get(firstTeam).getId());
							match.setTeamVisitorName(teamsAux.get(firstTeam).getName());
							match.setStatus("No jugado");
							
							LocalDateTime now = LocalDateTime.now();
							match.setDate(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
							match.setTime(now.getHour() + ":" + now.getMinute());
							
							matchRepository.save(match);
							gameCounter++;
							numberOfGames++;
						}
					}
					
					if(schedule.getRestingTeam() == null)
						schedule.setRestingTeam("Ninguno");
					
					schedule.setGamesProgrammed(numberOfGames);
				}
		}
		
		int numberOfClassifiedAux = numberOfClassified;
		
		for(int counter = 0; counter < numberofSchedules; counter++) {
			Playoff playoff = new Playoff();
			playoff.setTournament(tournament);
			playoff.setStatus("Pendiente");
			playoffRepository.save(playoff);
			
			int numberOfMatches = numberOfClassifiedAux / 2;
			int numberOfGames = 0;
			
			for(int counterMatches = 0; counterMatches < numberOfMatches; counterMatches++) {
				Match match = new Match();
				match.setPlayoff(playoff);
				match.setTeamLocalId(0);
				match.setTeamLocalName("Indefinido");
				match.setTeamVisitorId(0);
				match.setTeamVisitorName("Indefinido");
				match.setStatus("No jugado");
				
				LocalDateTime now = LocalDateTime.now();
				match.setDate(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
				match.setTime(now.getHour() + ":" + now.getMinute());
				
				matchRepository.save(match);
				numberOfGames++;
			}
			
			numberOfClassifiedAux /= 2;
			
			playoff.setGamesProgrammed(numberOfGames);
		}
		
		tournament.setNumberClassified(numberOfClassified);
		tournament.setSchema(tournamentAux.getSchema());
		tournament.setScheduleGenerated(true);
		tournament.setStatus("Puntos");
		tournament.setGamesProgrammed(gameCounter);
		tournament.setGamesPlayed(0);
		tournament.setSelection(tournamentAux.getSelection());
	}
}

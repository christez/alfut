package mx.christez.sla.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.Cluster;
import mx.christez.sla.entity.Team;
import mx.christez.sla.entity.Tournament;
import mx.christez.sla.exception.NoTournamentFoundException;
import mx.christez.sla.repository.ClusterRepository;
import mx.christez.sla.repository.TeamRepository;
import mx.christez.sla.repository.TournamentRepository;
import mx.christez.sla.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private ClusterRepository clusterRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TournamentRepository tournamentRepository;

	@Override
	public Tournament findTeams(int tournamentId) throws NoTournamentFoundException {
		Tournament tournament = tournamentRepository.findOne(tournamentId);
		
		if(tournament == null)
			throw new NoTournamentFoundException();
		
		List<Team> teams = teamRepository.findByTournamentOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(tournament);		
		tournament.setTeams(teams);
		
		return tournament;
	}

	@Override
	@Transactional
	public void save(int tournamentId, Team team) {
		Tournament tournament = tournamentRepository.findOne(tournamentId);
		
		team.setTournament(tournament);
		teamRepository.save(team);
	}

	@Override
	public Team findOne(int id) {
		return teamRepository.findOne(id);
	}

	@Override
	@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(String username, Team team) {
		teamRepository.delete(team);
	}

	@Override
	@Transactional
	public void update(String username, int teamId, Team team) {
		Team originalTeam = teamRepository.findOne(teamId);
		
		originalTeam.setGamesDrawed(team.getGamesDrawed());
		originalTeam.setGamesLost(team.getGamesLost());
		originalTeam.setGamesPlayed(team.getGamesPlayed());
		originalTeam.setGamesWon(team.getGamesWon());
		originalTeam.setGoalsAgainst(team.getGoalsAgainst());
		originalTeam.setGoalsDifference(team.getGoalsDifference());
		originalTeam.setGoalsFavor(team.getGoalsFavor());
		originalTeam.setName(team.getName());
		originalTeam.setPoints(team.getPoints());
	}

	@Override
	@Transactional
	public void saveWithCluster(int clusterId, Team team) {
		Cluster cluster = clusterRepository.findOne(clusterId);
		
		team.setCluster(cluster);
		teamRepository.save(team);
	}
}

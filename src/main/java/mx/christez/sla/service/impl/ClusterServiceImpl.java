package mx.christez.sla.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.Cluster;
import mx.christez.sla.entity.Team;
import mx.christez.sla.entity.Tournament;
import mx.christez.sla.exception.NoClusterFoundException;
import mx.christez.sla.exception.NoTournamentFoundException;
import mx.christez.sla.repository.ClusterRepository;
import mx.christez.sla.repository.TeamRepository;
import mx.christez.sla.repository.TournamentRepository;
import mx.christez.sla.service.ClusterService;

@Service
public class ClusterServiceImpl implements ClusterService {
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TournamentRepository tournamentRepository;
	
	@Autowired
	private ClusterRepository clusterRepository;

	@Override
	public Tournament findClusters(int tournamentId) throws NoTournamentFoundException {
		Tournament tournament = tournamentRepository.findOne(tournamentId);
		
		if(tournament == null)
			throw new NoTournamentFoundException();
		
		List<Cluster> clusters = clusterRepository.findByTournamentOrderByIdAsc(tournament);
		
		for(Cluster cluster: clusters) {
			List<Team> teams = teamRepository.findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(cluster);
			cluster.setTeams(teams);
		}
		
		tournament.setClusters(clusters);
		
		return tournament;
	}

	@Override
	public void save(int tournamentId, Cluster cluster) {
		Tournament tournament = tournamentRepository.findOne(tournamentId);
		
		cluster.setTournament(tournament);
		clusterRepository.save(cluster);
	}

	@Override
	public Cluster findOne(int id) {
		return clusterRepository.findOne(id);
	}

	@Override
	@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(String username, Cluster cluster) {
		clusterRepository.delete(cluster);
	}

	@Override
	public Object findOneWithTournamentAndTeams(int clusterId) throws NoClusterFoundException {
		Cluster cluster = clusterRepository.findOne(clusterId);
		
		if(cluster == null)
			throw new NoClusterFoundException();
		
		Tournament tournament = cluster.getTournament();
		List<Team> teams = teamRepository.findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(cluster);
		
		cluster.setTournament(tournament);
		cluster.setTeams(teams);
		
		return cluster;
	}
}

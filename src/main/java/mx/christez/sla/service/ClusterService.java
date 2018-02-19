package mx.christez.sla.service;

import mx.christez.sla.entity.Cluster;
import mx.christez.sla.entity.Tournament;
import mx.christez.sla.exception.NoClusterFoundException;
import mx.christez.sla.exception.NoTournamentFoundException;

public interface ClusterService {
	Tournament findClusters(int tournamentId) throws NoTournamentFoundException;

	void save(int tournamentId, Cluster cluster);

	Cluster findOne(int id);

	void delete(String username, Cluster cluster);

	Object findOneWithTournamentAndTeams(int clusterId) throws NoClusterFoundException ;
}

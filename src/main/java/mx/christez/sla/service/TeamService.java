package mx.christez.sla.service;

import mx.christez.sla.entity.Team;
import mx.christez.sla.entity.Tournament;
import mx.christez.sla.exception.NoTournamentFoundException;

public interface TeamService {
	Tournament findTeams(int tournamentId) throws NoTournamentFoundException;

	void save(int tournamentId, Team team);

	Team findOne(int id);

	void delete(String username, Team team);

	void update(String username, int teamId, Team team);

	void saveWithCluster(int clusterId, Team team);
}

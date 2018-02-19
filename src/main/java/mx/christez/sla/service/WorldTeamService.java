package mx.christez.sla.service;

import mx.christez.sla.entity.WorldTeam;

public interface WorldTeamService {
	void delete(WorldTeam team);

	WorldTeam findOne(int id);

	void update(int teamId, WorldTeam team);
}

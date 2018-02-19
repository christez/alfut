package mx.christez.sla.service;

import mx.christez.sla.entity.WorldTournament;

public interface WorldTournamentService {
	void save(int leagueId, WorldTournament tournament);

	WorldTournament findOne(int id);

	void delete(WorldTournament tournament);
}

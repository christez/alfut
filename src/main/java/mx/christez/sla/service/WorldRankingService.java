package mx.christez.sla.service;

import mx.christez.sla.entity.WorldRanking;
import mx.christez.sla.entity.WorldTournament;

public interface WorldRankingService {
	WorldTournament findByTournament(int tournamentId);

	void save(int tournamentId, WorldRanking ranking);

	WorldRanking findOne(int id);

	void delete(WorldRanking ranking);
}

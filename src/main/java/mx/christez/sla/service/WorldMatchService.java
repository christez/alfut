package mx.christez.sla.service;

import mx.christez.sla.entity.WorldMatch;

public interface WorldMatchService {
	WorldMatch findOne(int id);

	void delete(WorldMatch match);

	void update(int matchId, WorldMatch match);
}

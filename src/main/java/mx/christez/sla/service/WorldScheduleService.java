package mx.christez.sla.service;

import mx.christez.sla.entity.WorldSchedule;

public interface WorldScheduleService {
	void save(int tournamentId, WorldSchedule schedule);

	WorldSchedule findOne(int id);

	void delete(WorldSchedule schedule);
}

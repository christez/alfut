package mx.christez.sla.service;

import mx.christez.sla.entity.Tournament;
import mx.christez.sla.exception.NoTeamsFoundException;
import mx.christez.sla.exception.NotEnoughClustersFoundException;
import mx.christez.sla.exception.IncorrectNumberOfClustersException;
import mx.christez.sla.exception.NotEnoughTeamsFoundException;

public interface ScheduleService {
	void generateSchedulePoints(int tournamentId, Tournament tournament, String params) throws NoTeamsFoundException, NotEnoughTeamsFoundException;

	void generateScheduleGroups(int tournamentId, Tournament tournament) throws NotEnoughClustersFoundException, IncorrectNumberOfClustersException, NoTeamsFoundException, NotEnoughTeamsFoundException;
	
	void generateSchedulePlayoffs(int tournamentId, Tournament tournament) throws NoTeamsFoundException, NotEnoughTeamsFoundException;
}

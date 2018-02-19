package mx.christez.sla.service;

import mx.christez.sla.entity.Match;
import mx.christez.sla.exception.NoMatchFoundException;

public interface MatchService {
	Object findOne(int matchId) throws NoMatchFoundException ;

	void update(int matchId, Match match);	
}

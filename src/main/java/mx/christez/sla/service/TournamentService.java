package mx.christez.sla.service;

import java.util.List;

import mx.christez.sla.entity.League;
import mx.christez.sla.entity.Tournament;
import mx.christez.sla.exception.NoLeagueFoundException;
import mx.christez.sla.exception.NoTournamentFoundException;

public interface TournamentService {
	League findTournaments(int leagueId) throws NoLeagueFoundException;

	void save(int leagueId, Tournament tournament);

	Tournament findOne(int id);

	void delete(String username, Tournament tournament);

	Tournament findOneWithSchedulesAndMatches(int tournamentId) throws NoTournamentFoundException;

	void update(int tournamentId, Tournament tournament);

	List<Tournament> findAll();
}

package mx.christez.sla.service;

import java.util.List;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.League;

public interface LeagueService {
	public void save(League league, String username);

	public AppUser findLeagues(String username);

	public League findOne(int id);

	public void delete(League league);

	public void update(int leagueId, League league);

	public List<League> findAll();

	public List<League> findAll(String leagueName);

	public List<String> findByContent(String name);

	public League findOneWithTournaments(int leagueId);
}

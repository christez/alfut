package mx.christez.sla.service;

import java.util.List;

import mx.christez.sla.entity.WorldLeague;

public interface WorldLeagueService {
	public void save(WorldLeague league);

	public List<WorldLeague> findAll();

	public WorldLeague findOne(int leagueId);

	public void delete(WorldLeague league);

	public WorldLeague findOneWithData(int leagueId);
}

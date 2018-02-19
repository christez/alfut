package mx.christez.sla.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.WorldLeague;
import mx.christez.sla.entity.WorldMatch;
import mx.christez.sla.entity.WorldSchedule;
import mx.christez.sla.entity.WorldTournament;
import mx.christez.sla.repository.WorldLeagueRepository;
import mx.christez.sla.repository.WorldMatchRepository;
import mx.christez.sla.repository.WorldScheduleRepository;
import mx.christez.sla.repository.WorldTournamentRepository;
import mx.christez.sla.service.WorldTournamentService;

@Service
public class WorldTournamentServiceImpl implements WorldTournamentService {
	@Autowired
	private WorldLeagueRepository worldLeagueRepository;
	
	@Autowired
	private WorldMatchRepository worldMatchRepository;
	
	@Autowired
	private WorldTournamentRepository worldTournamentRepository;
	
	@Autowired
	private WorldScheduleRepository worldScheduleRepository;

	@Override
	public void save(int leagueId, WorldTournament tournament) {
		WorldLeague league = worldLeagueRepository.findOne(leagueId);
		tournament.setLeague(league);
		worldTournamentRepository.save(tournament);
	}

	@Override
	public WorldTournament findOne(int id) {
		WorldTournament tournament = worldTournamentRepository.findOne(id);
		List<WorldSchedule> schedules = worldScheduleRepository.findByTournament(tournament);
		
		for(WorldSchedule schedule: schedules) {
			List<WorldMatch> matches = worldMatchRepository.findBySchedule(schedule);
			schedule.setMatches(matches);
		}
		
		tournament.setSchedules(schedules);		
		return tournament;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(WorldTournament tournament) {
		worldTournamentRepository.delete(tournament);
	}

	
}

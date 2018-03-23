package mx.christez.sla.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.WorldLeague;
import mx.christez.sla.entity.WorldMatch;
import mx.christez.sla.entity.WorldRanking;
import mx.christez.sla.entity.WorldSchedule;
import mx.christez.sla.entity.WorldTeam;
import mx.christez.sla.entity.WorldTournament;
import mx.christez.sla.repository.WorldLeagueRepository;
import mx.christez.sla.repository.WorldMatchRepository;
import mx.christez.sla.repository.WorldRankingRepository;
import mx.christez.sla.repository.WorldScheduleRepository;
import mx.christez.sla.repository.WorldTeamRepository;
import mx.christez.sla.repository.WorldTournamentRepository;
import mx.christez.sla.service.WorldLeagueService;

@Service
public class WorldLeagueServiceImpl implements WorldLeagueService {
	@Autowired
	private WorldLeagueRepository worldLeagueRepository;
	
	@Autowired
	private WorldMatchRepository worldMatchRepository;
	
	@Autowired
	private WorldRankingRepository worldRankingRepository;
	
	@Autowired
	private WorldScheduleRepository worldScheduleRepository;
	
	@Autowired
	private WorldTeamRepository worldTeamRepository;
	
	@Autowired
	private WorldTournamentRepository worldTournamentRepository;

	@Override
	@Transactional
	public void save(WorldLeague league) {
		worldLeagueRepository.save(league);
	}

	@Override
	public List<WorldLeague> findAll() {
		return worldLeagueRepository.findAllByOrderByNameAsc();
	}

	@Override
	public WorldLeague findOne(int leagueId) {
		WorldLeague league = worldLeagueRepository.findOne(leagueId);
		List<WorldTournament> tournaments = worldTournamentRepository.findByLeagueOrderByNameAsc(league);
		league.setTournaments(tournaments);
		
		return league;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(WorldLeague league) {
		worldLeagueRepository.delete(league);
	}

	@Override
	public WorldLeague findOneWithData(int leagueId) {
		WorldLeague league = worldLeagueRepository.findOne(leagueId);
		List<WorldTournament> tournaments = worldTournamentRepository.findByLeagueOrderByNameAsc(league);
		
		for(WorldTournament tournament: tournaments) {
			List<WorldSchedule> schedules = worldScheduleRepository.findByTournament(tournament);
			
			for(WorldSchedule schedule: schedules) {
				List<WorldMatch> matches = worldMatchRepository.findBySchedule(schedule);
				schedule.setMatches(matches);
			}
			
			tournament.setSchedules(schedules);
			
			List<WorldRanking> rankings = worldRankingRepository.findByTournamentOrderByNameAsc(tournament);
			
			for(WorldRanking ranking: rankings) {
				List<WorldTeam> teams = worldTeamRepository.findByRanking(ranking);
				ranking.setTeams(teams);
			}
				
			tournament.setRankings(rankings);
		}
		
		league.setTournaments(tournaments);
		
		return league;
	}
}

package mx.christez.sla.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.Cluster;
import mx.christez.sla.entity.League;
import mx.christez.sla.entity.Match;
import mx.christez.sla.entity.Playoff;
import mx.christez.sla.entity.Schedule;
import mx.christez.sla.entity.Tournament;
import mx.christez.sla.exception.NoLeagueFoundException;
import mx.christez.sla.exception.NoTournamentFoundException;
import mx.christez.sla.repository.ClusterRepository;
import mx.christez.sla.repository.LeagueRepository;
import mx.christez.sla.repository.MatchRepository;
import mx.christez.sla.repository.PlayoffRepository;
import mx.christez.sla.repository.ScheduleRepository;
import mx.christez.sla.repository.TournamentRepository;
import mx.christez.sla.service.TournamentService;

@Service
public class TournamentServiceImpl implements TournamentService {
	@Autowired
	private ClusterRepository clusterRepository;
	
	@Autowired
	private LeagueRepository leagueRepository;
	
	@Autowired
	private MatchRepository matchRepository;
	
	@Autowired
	private PlayoffRepository playoffRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private TournamentRepository tournamentRepository;

	@Override
	public League findTournaments(int leagueId) throws NoLeagueFoundException {
		League league = leagueRepository.findOne(leagueId);
		
		if(league == null)
			throw new NoLeagueFoundException();
		
		List<Tournament> tournaments = tournamentRepository.findByLeagueOrderByNameAsc(league);		
		league.setTournaments(tournaments);
		
		return league;
	}

	@Override
	@Transactional
	public void save(int leagueId, Tournament tournament) {
		League league = leagueRepository.findOne(leagueId);
		
		tournament.setLeague(league);
		tournament.setCreationDate(new Date());
		tournament.setScheduleGenerated(false);
		tournament.setStatus("Configuración");
		tournamentRepository.save(tournament);		
	}

	@Override
	public Tournament findOne(int id) {
		return tournamentRepository.findOne(id);
	}

	@Override
	@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(String username, Tournament tournament) {
		tournamentRepository.delete(tournament);		
	}

	@Override
	public Tournament findOneWithSchedulesAndMatches(int tournamentId) throws NoTournamentFoundException {
		Tournament tournament = tournamentRepository.findOne(tournamentId);
		
		if(tournament == null)
			throw new NoTournamentFoundException();
		
		List<Schedule> schedules = scheduleRepository.findByTournamentOrderByIdAsc(tournament);
		
		for(Schedule schedule: schedules) {
			List<Match> matches = matchRepository.findByScheduleOrderByDateAscTimeAsc(schedule);
			schedule.setMatches(matches);
		}
		
		tournament.setSchedules(schedules);
		
		List<Cluster> clusters = clusterRepository.findByTournamentOrderByIdAsc(tournament);
		
		for(Cluster cluster: clusters) {
			List<Schedule> clusterSchedules = scheduleRepository.findByClusterOrderByIdAsc(cluster);
			
			for(Schedule schedule: clusterSchedules) {
				List<Match> matches = matchRepository.findByScheduleOrderByDateAscTimeAsc(schedule);
				schedule.setMatches(matches);
			}
			
			cluster.setSchedules(clusterSchedules);
		}
		
		tournament.setClusters(clusters);
		
		List<Playoff> playoffs = playoffRepository.findByTournamentOrderByIdAsc(tournament);
		
		for(Playoff playoff: playoffs) {
			List<Match> matches = matchRepository.findByPlayoffOrderByDateAscTimeAsc(playoff);
			playoff.setMatches(matches);
		}
		
		tournament.setPlayoffs(playoffs);
		
		return tournament;
	}

	@Override
	@Transactional
	public void update(int tournamentId, Tournament tournament) {
		Tournament originalTournament = tournamentRepository.findOne(tournamentId);
		
		originalTournament.setName(tournament.getName());
		originalTournament.setDescription(tournament.getDescription());
	}

	@Override
	public List<Tournament> findAll() {
		Page<Tournament> tournaments = tournamentRepository.findAll(new PageRequest(0, 4, Direction.DESC, "creationDate"));
		List<Tournament> tournamentList = tournaments.getContent();
		
		return tournamentList;
	}
}

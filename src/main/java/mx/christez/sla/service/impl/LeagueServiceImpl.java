package mx.christez.sla.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.League;
import mx.christez.sla.repository.LeagueRepository;
import mx.christez.sla.repository.TournamentRepository;
import mx.christez.sla.repository.UserRepository;
import mx.christez.sla.service.LeagueService;

@Service
public class LeagueServiceImpl implements LeagueService {
	@Autowired
	private LeagueRepository leagueRepository;
	
	@Autowired
	private TournamentRepository tournamentRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public void save(League league, String username) {
		AppUser user = userRepository.findByUsername(username);
		league.setUser(user);
		league.setCreationDate(new Date());
		league.setLattitud(19.4076879);
		league.setLongitud(-99.1592822);
		leagueRepository.save(league);
	}

	@Override
	@Transactional
	public AppUser findLeagues(String username) {
		AppUser user = userRepository.findByUsername(username);
		List<League> leagues = leagueRepository.findByUser(user);
		user.setLeagues(leagues);		
		
		return user;
	}

	@Override
	public League findOne(int id) {
		return leagueRepository.findOne(id);
	}

	@Override
	@PreAuthorize("#league.user.username == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(League league) {
		leagueRepository.delete(league);
	}

	@Override
	@Transactional
	public void update(int leagueId, League league) {
		League originalLeague = leagueRepository.findOne(leagueId);
		
		originalLeague.setAdditionalInfo(league.getAdditionalInfo());
		originalLeague.setLattitud(league.getLattitud());
		originalLeague.setLongitud(league.getLongitud());
		originalLeague.setName(league.getName());
	}

	@Override
	public List<League> findAll() {
		Page<League> leagues = leagueRepository.findAll(new PageRequest(0, 4, Direction.DESC, "creationDate"));
		List<League> leagueList = leagues.getContent();
		
		return leagueList;
	}

	@Override
	public List<League> findAll(String leagueName) {
		return leagueRepository.findByNameStartingWithOrderByNameAsc(leagueName);
	}

	@Override
	public List<String> findByContent(String name) {
		List<League> leagues = leagueRepository.findByNameContaining(name);
		List<String> names = new ArrayList<String>();
		
		for(League league: leagues)
			names.add(league.getName());
		
		return names;
	}

	@Override
	public League findOneWithTournaments(int leagueId) {
		League league = leagueRepository.findOne(leagueId);		
		league.setTournaments(tournamentRepository.findByLeagueOrderByNameAsc(league));
			
		return league;
	}
}

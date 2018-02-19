package mx.christez.sla.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.ExceptionRecords;
import mx.christez.sla.entity.WorldRanking;
import mx.christez.sla.entity.WorldTeam;
import mx.christez.sla.entity.WorldTournament;
import mx.christez.sla.repository.ExceptionRecordsRepository;
import mx.christez.sla.repository.WorldRankingRepository;
import mx.christez.sla.repository.WorldTeamRepository;
import mx.christez.sla.repository.WorldTournamentRepository;
import mx.christez.sla.service.WorldRankingService;

@Service
public class WorldRankingServiceImpl implements WorldRankingService {
	@Autowired
	private ExceptionRecordsRepository exceptionRecordsRepository;
	
	@Autowired
	private WorldRankingRepository worldRankingRepository;
	
	@Autowired
	private WorldTeamRepository worldTeamRepository;
	
	@Autowired
	private WorldTournamentRepository worldTournamentRepository;
	
	@Override
	public WorldTournament findByTournament(int tournamentId) {
		WorldTournament tournament = worldTournamentRepository.findOne(tournamentId);
		List<WorldRanking> rankings = worldRankingRepository.findByTournamentOrderByNameAsc(tournament);
		
		for(WorldRanking ranking: rankings) {
			List<WorldTeam> teams = worldTeamRepository.findByRankingOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(ranking);
			ranking.setTeams(teams);
		}
		
		tournament.setRankings(rankings);
		return tournament;
	}

	@Override
	public void save(int tournamentId, WorldRanking ranking) {
		WorldTournament tournament = worldTournamentRepository.findOne(tournamentId);
		ranking.setTournament(tournament);
		worldRankingRepository.save(ranking);
		
		String [] teams = ranking.getTextForTeams().split("\\|");
		
		for(String team: teams) {
			try {
				WorldTeam worldTeam = new WorldTeam();
				worldTeam.setGamesDrawed(0);
				worldTeam.setGamesLost(0);
				worldTeam.setGamesPlayed(0);
				worldTeam.setGamesWon(0);
				worldTeam.setGoalsAgainst(0);
				worldTeam.setGoalsDifference(0);
				worldTeam.setGoalsFavor(0);
				worldTeam.setName(team);
				worldTeam.setPoints(0);
				worldTeam.setRanking(ranking);
				
				worldTeamRepository.save(worldTeam);
			}catch(Exception e) {
				exceptionRecordsRepository.save(new ExceptionRecords("Enfrentamiento: " + ranking.getTextForTeams(), "Exception: " + e.getMessage(), "WorldRankingServiceImpl.save"));
			}
		}
		
	}

	@Override
	public WorldRanking findOne(int id) {
		return worldRankingRepository.findOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(WorldRanking ranking) {
		worldRankingRepository.delete(ranking);
	}
}

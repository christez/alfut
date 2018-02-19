package mx.christez.sla.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.ExceptionRecords;
import mx.christez.sla.entity.WorldMatch;
import mx.christez.sla.entity.WorldSchedule;
import mx.christez.sla.entity.WorldTournament;
import mx.christez.sla.repository.ExceptionRecordsRepository;
import mx.christez.sla.repository.WorldMatchRepository;
import mx.christez.sla.repository.WorldScheduleRepository;
import mx.christez.sla.repository.WorldTournamentRepository;
import mx.christez.sla.service.WorldScheduleService;

@Service
public class WorldScheduleServiceImpl implements WorldScheduleService {
	@Autowired
	private ExceptionRecordsRepository exceptionRecordsRepository;
	
	@Autowired
	private WorldMatchRepository worldMatchRepository;
	
	@Autowired
	private WorldScheduleRepository worldScheduleRepository;
	
	@Autowired
	private WorldTournamentRepository worldTournamentRepository;

	@Override
	public void save(int tournamentId, WorldSchedule schedule) {
		WorldTournament tournament = worldTournamentRepository.findOne(tournamentId);
		schedule.setTournament(tournament);
		worldScheduleRepository.save(schedule);
		
		String [] matches = schedule.getTextForMatches().split("\\|");
		
		for(String match: matches) {
			try {
				String [] data = match.split("#");
				WorldMatch worldMatch = new WorldMatch();
				worldMatch.setDate(data[0]);
				worldMatch.setLocalGoals(data[1]);
				worldMatch.setLocalName(data[2]);
				worldMatch.setTime(data[3]);
				worldMatch.setVisitorGoals(data[4]);
				worldMatch.setVisitorName(data[5]);
				worldMatch.setSchedule(schedule);
				
				worldMatchRepository.save(worldMatch);
			}catch(Exception e) {
				exceptionRecordsRepository.save(new ExceptionRecords("Enfrentamiento: " + schedule.getTextForMatches(), "Exception: " + e.getMessage(), "WorldScheduleServiceImpl.save"));
			}
		}
	}

	@Override
	public WorldSchedule findOne(int id) {
		return worldScheduleRepository.findOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(WorldSchedule schedule) {
		worldScheduleRepository.delete(schedule);
	}
}

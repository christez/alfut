package mx.christez.sla.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.WorldMatch;
import mx.christez.sla.repository.WorldMatchRepository;
import mx.christez.sla.service.WorldMatchService;

@Service
public class WorldMatchServiceImpl implements WorldMatchService {
	@Autowired
	private WorldMatchRepository worldMatchRepository;

	@Override
	public WorldMatch findOne(int id) {
		return worldMatchRepository.findOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(WorldMatch match) {
		worldMatchRepository.delete(match);
	}

	@Override
	@Transactional
	public void update(int matchId, WorldMatch match) {
		WorldMatch worldMatch = worldMatchRepository.findOne(matchId);
		
		worldMatch.setDate(match.getDate());
		worldMatch.setLocalGoals(match.getLocalGoals());
		worldMatch.setLocalName(match.getLocalName());
		worldMatch.setTime(match.getTime());
		worldMatch.setVisitorGoals(match.getVisitorGoals());
		worldMatch.setVisitorName(match.getVisitorName());
	}
	
}

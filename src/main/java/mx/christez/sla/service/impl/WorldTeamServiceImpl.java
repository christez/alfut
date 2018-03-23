package mx.christez.sla.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.WorldTeam;
import mx.christez.sla.repository.WorldTeamRepository;
import mx.christez.sla.service.WorldTeamService;

@Service
public class WorldTeamServiceImpl implements WorldTeamService {
	@Autowired
	private WorldTeamRepository worldTeamRepository;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(WorldTeam team) {
		worldTeamRepository.delete(team);
	}

	@Override
	public WorldTeam findOne(int id) {
		return worldTeamRepository.findOne(id);
	}

	@Override
	@Transactional
	public void update(int teamId, WorldTeam team) {
		WorldTeam originalTeam = worldTeamRepository.findOne(teamId);
		originalTeam.setGamesDrawed(team.getGamesDrawed());
		originalTeam.setGamesLost(team.getGamesLost());
		originalTeam.setGamesPlayed(team.getGamesPlayed());
		originalTeam.setGamesWon(team.getGamesWon());
		originalTeam.setGoals(team.getGoals());
		originalTeam.setName(team.getName());
		originalTeam.setPoints(team.getPoints());
		originalTeam.setPosition(team.getPosition());
	}	
}

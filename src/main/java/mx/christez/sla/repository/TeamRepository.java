package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.Cluster;
import mx.christez.sla.entity.Team;
import mx.christez.sla.entity.Tournament;

public interface TeamRepository extends JpaRepository<Team, Integer>{
	List<Team> findByTournamentOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(Tournament tournament);

	List<Team> findByTournament(Tournament tournament);

	List<Team> findByClusterOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(Cluster cluster);
}

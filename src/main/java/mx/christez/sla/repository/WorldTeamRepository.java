package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.WorldRanking;
import mx.christez.sla.entity.WorldTeam;

public interface WorldTeamRepository extends JpaRepository<WorldTeam, Integer>{
	List<WorldTeam> findByRankingOrderByPointsDescGoalsDifferenceDescGoalsFavorDesc(WorldRanking ranking);
}

package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.WorldRanking;
import mx.christez.sla.entity.WorldTournament;

public interface WorldRankingRepository extends JpaRepository<WorldRanking, Integer>{
	List<WorldRanking> findByTournamentOrderByNameAsc(WorldTournament tournament);
}

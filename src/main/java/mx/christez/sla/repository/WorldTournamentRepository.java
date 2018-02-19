package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.WorldLeague;
import mx.christez.sla.entity.WorldTournament;

public interface WorldTournamentRepository extends JpaRepository<WorldTournament, Integer>{
	List<WorldTournament> findByLeagueOrderByNameAsc(WorldLeague league);
}

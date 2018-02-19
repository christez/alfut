package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.WorldLeague;

public interface WorldLeagueRepository extends JpaRepository<WorldLeague, Integer>{
	List<WorldLeague> findAllByOrderByNameAsc();
}

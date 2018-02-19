package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.Playoff;
import mx.christez.sla.entity.Tournament;

public interface PlayoffRepository extends JpaRepository<Playoff, Integer>{
	List<Playoff> findByTournamentOrderByIdAsc(Tournament tournament);
}

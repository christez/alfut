package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.League;
import mx.christez.sla.entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer>{
	List<Tournament> findByLeagueOrderByNameAsc(League league);
}

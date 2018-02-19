package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.Match;
import mx.christez.sla.entity.Playoff;
import mx.christez.sla.entity.Schedule;

public interface MatchRepository extends JpaRepository<Match, Integer>{
	List<Match> findByScheduleOrderByDateAscTimeAsc(Schedule schedule);
	
	List<Match> findByPlayoffOrderByDateAscTimeAsc(Playoff playoff);
}

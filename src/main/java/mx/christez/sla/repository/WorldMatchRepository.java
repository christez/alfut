package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.WorldMatch;
import mx.christez.sla.entity.WorldSchedule;

public interface WorldMatchRepository extends JpaRepository<WorldMatch, Integer>{
	List<WorldMatch> findBySchedule(WorldSchedule schedule);
}

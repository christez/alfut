package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.WorldSchedule;
import mx.christez.sla.entity.WorldTournament;

public interface WorldScheduleRepository extends JpaRepository<WorldSchedule, Integer>{
	List<WorldSchedule> findByTournament(WorldTournament tournament);
}

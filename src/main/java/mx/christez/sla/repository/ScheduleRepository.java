package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.Cluster;
import mx.christez.sla.entity.Schedule;
import mx.christez.sla.entity.Tournament;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	List<Schedule> findByTournamentOrderByIdAsc(Tournament tournament);

	List<Schedule> findByClusterOrderByIdAsc(Cluster cluster);
}

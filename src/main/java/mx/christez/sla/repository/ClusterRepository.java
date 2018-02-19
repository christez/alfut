package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.Cluster;
import mx.christez.sla.entity.Tournament;

public interface ClusterRepository extends JpaRepository<Cluster, Integer>{
	List<Cluster> findByTournamentOrderByIdAsc(Tournament tournament);
}

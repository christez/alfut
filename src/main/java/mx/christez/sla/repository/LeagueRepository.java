package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.League;

public interface LeagueRepository extends JpaRepository<League, Integer>{
	List<League> findByUser(AppUser user);

	List<League> findByNameStartingWithOrderByNameAsc(String leagueName);

	List<League> findByNameContaining(String name);
}

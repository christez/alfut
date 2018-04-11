package mx.christez.sla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.Commercial;

public interface CommercialRepository extends JpaRepository<Commercial, Integer>{
	
}

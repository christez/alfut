package mx.christez.sla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.SupportCase;

public interface SupportRepository extends JpaRepository<SupportCase, Integer>{
	SupportCase findByUser(AppUser user);
}

package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.New;

public interface NewRepository extends JpaRepository<New, Integer>{
	List<New> findByUser(AppUser user, Pageable pagable);
}

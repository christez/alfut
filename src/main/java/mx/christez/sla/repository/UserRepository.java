package mx.christez.sla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, String>{
	AppUser findByName(String name);

	AppUser findByUsername(String username);
}

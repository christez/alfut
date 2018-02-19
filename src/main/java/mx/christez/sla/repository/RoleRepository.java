package mx.christez.sla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByName(String string);
}

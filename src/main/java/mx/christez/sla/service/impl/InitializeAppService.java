package mx.christez.sla.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.Role;
import mx.christez.sla.repository.RoleRepository;
import mx.christez.sla.repository.UserRepository;

@Transactional
@Service
public class InitializeAppService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init() {
		if(roleRepository.findByName("ROLE_ADMIN") == null) {
			Role roleUser = new Role();
			roleUser.setName("ROLE_USER");
			roleRepository.save(roleUser);
			
			Role roleAdmin = new Role();
			roleAdmin.setName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);
			
			AppUser userAdmin = new AppUser();
			userAdmin.setUsername("admin");
			userAdmin.setName("admin");
			userAdmin.setLastname("admin");
			userAdmin.setEmail("admin@admin.com");
			userAdmin.setEnabled(true);
			userAdmin.setSecretQuestion("Nombre de tu primera mascota");
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();		
			//userAdmin.setPassword(encoder.encode("ALFut4dm1n4cc3ss"));
			userAdmin.setPassword(encoder.encode("admin"));
			userAdmin.setSecretAnswer(encoder.encode("suker".toLowerCase()));
			
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleAdmin);
			userAdmin.setRoles(roles);
			userRepository.save(userAdmin);
		}
	}
}

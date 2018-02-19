package mx.christez.sla.service.impl;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.Role;
import mx.christez.sla.exception.NoSecretDataFoundException;
import mx.christez.sla.exception.NoUserFoundException;
import mx.christez.sla.repository.RoleRepository;
import mx.christez.sla.repository.UserRepository;
import mx.christez.sla.security.Encrypter;
import mx.christez.sla.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private Encrypter encrypter;

	@Override
	@Transactional
	public void save(AppUser user) {
		user.setEnabled(true);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		try {user.setSecretAnswer(encrypter.encrypt(user.getSecretAnswer().toLowerCase()));}catch(Exception e) {/*Don't do anything*/}
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);

		userRepository.save(user);
	}

	@Override
	public AppUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	@Transactional
	public int activateAccount(String code) {
		try {
			String username = encrypter.decrypt(code).split(":")[0];
			AppUser user = userRepository.findByUsername(username);

			if (user == null)
				return -1;

			user.setEnabled(true);
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public String restorePassword(String code) {
		try {
			String username = encrypter.decrypt(code).split(":")[0];
			return username;
		} catch (Exception e) {
			return "An exception occured while decrypting: " + e.getMessage();
		}
	}

	@Override
	@Transactional
	public String update(String username) {
		AppUser appUser = userRepository.findByUsername(username);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Random random = new SecureRandom();

		String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789";
		String temporalPassword = "";

		for (int counter = 0; counter < 8; counter++) {
			int index = (int)(random.nextDouble() * letters.length());
			temporalPassword += letters.substring(index, index + 1);
		}

		appUser.setPassword(encoder.encode(temporalPassword));
		return temporalPassword;
	}

	@Override
	@Transactional
	public void modify(String username, AppUser appUser) {
		AppUser originalAppUser = userRepository.findByUsername(username);		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		originalAppUser.setEmail(appUser.getEmail());
		originalAppUser.setLastname(appUser.getLastname());
		originalAppUser.setName(appUser.getName());
		originalAppUser.setPassword(encoder.encode(appUser.getPassword()));
		try{originalAppUser.setSecretAnswer(encrypter.encrypt(appUser.getSecretAnswer().toLowerCase()));}catch(Exception e) {/*Don't do anything*/}
	}

	@Override
	public Page<AppUser> findAll(int page) {
		return userRepository.findAll(new PageRequest(page - 1, 10, Direction.ASC, "username"));
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(AppUser user) {
		userRepository.delete(user);
	}

	@Override
	@Transactional
	public String recover(AppUser appUser) throws NoUserFoundException, NoSecretDataFoundException {
		AppUser originalUser = userRepository.findByUsername(appUser.getUsername().toString());
		
		if(originalUser == null)
			throw new NoUserFoundException();
		
		String secretAnswer = "";
		try {secretAnswer = encrypter.encrypt(appUser.getSecretAnswer().toLowerCase());}catch(Exception e) {/*Don't do anything*/}
		
		System.out.println("appUser: " + secretAnswer);
		System.out.println("originalUser: " + originalUser.getSecretAnswer());
		
		if(originalUser.getSecretQuestion().equals(appUser.getSecretQuestion()) && originalUser.getSecretAnswer().equals(secretAnswer))
			return update(originalUser.getUsername());
		else
			throw new NoSecretDataFoundException();
	}
}

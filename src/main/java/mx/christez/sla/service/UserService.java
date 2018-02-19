package mx.christez.sla.service;

import org.springframework.data.domain.Page;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.exception.NoSecretDataFoundException;
import mx.christez.sla.exception.NoUserFoundException;

public interface UserService {
	public void save(AppUser user);

	public AppUser findByUsername(String username);

	public int activateAccount(String code);

	public String restorePassword(String code);

	public String update(String username);

	public void modify(String username, AppUser appUser);

	public Page<AppUser> findAll(int page);

	public void delete(AppUser user);

	public String recover(AppUser appUser) throws NoUserFoundException, NoSecretDataFoundException ;
}

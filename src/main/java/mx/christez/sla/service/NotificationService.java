package mx.christez.sla.service;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.exception.InvalidUserException;

public interface NotificationService {
	public void notifyActivation(AppUser user);

	public void recoverPassword(AppUser appUser) throws InvalidUserException ;
}

package mx.christez.sla.service;

import mx.christez.sla.entity.SupportCase;
import mx.christez.sla.exception.NoSupportCaseFoundException;

public interface SupportService {
	void save(String username, SupportCase supportCase);

	SupportCase findOne(int id) throws NoSupportCaseFoundException ;

	void delete(SupportCase supportCase);

	Object findByUsername(String username);

	Object findFirstCreated();

	Object findOneWithConversations(int id) throws NoSupportCaseFoundException ;	
}

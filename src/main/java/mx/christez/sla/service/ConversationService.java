package mx.christez.sla.service;

import mx.christez.sla.entity.Conversation;

public interface ConversationService {
	void saveFromUser(String username, Conversation conversation);

	void saveFromAdministrator(int supportCaseId, Conversation conversation);
}

package mx.christez.sla.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.Conversation;
import mx.christez.sla.entity.SupportCase;
import mx.christez.sla.repository.ConversationRepository;
import mx.christez.sla.repository.SupportRepository;
import mx.christez.sla.repository.UserRepository;
import mx.christez.sla.service.ConversationService;

@Service
public class ConversationServiceImpl implements ConversationService {
	@Autowired
	private ConversationRepository conversationRepository;
	
	@Autowired
	private SupportRepository supportRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public void saveFromUser(String username, Conversation conversation) {
		AppUser user = userRepository.findByUsername(username);
		SupportCase supportCase = supportRepository.findByUser(user);
		supportCase.setStatus("Respuesta");
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		conversation.setMessageUser(formatter.format(date) + ": " + conversation.getMessageUser());
		conversation.setSupportCase(supportCase);
		conversationRepository.save(conversation);
	}

	@Override
	@Transactional
	public void saveFromAdministrator(int supportCaseId, Conversation conversation) {
		SupportCase supportCase = supportRepository.findOne(supportCaseId);
		supportCase.setStatus("Mensaje");
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		List<Conversation> conversations = supportCase.getConversations();
		conversations.get(conversations.size() - 1).setMessageAdministrator(formatter.format(date) + ": " + conversation.getMessageUser());
	}
}

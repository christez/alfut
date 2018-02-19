package mx.christez.sla.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.Conversation;
import mx.christez.sla.entity.SupportCase;
import mx.christez.sla.exception.NoSupportCaseFoundException;
import mx.christez.sla.repository.ConversationRepository;
import mx.christez.sla.repository.SupportRepository;
import mx.christez.sla.repository.UserRepository;
import mx.christez.sla.service.SupportService;

@Service
public class SupportServiceImpl implements SupportService {
	@Autowired
	private ConversationRepository conversationRepository;
	
	@Autowired
	private SupportRepository supportRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public void save(String username, SupportCase supportCase) {
		AppUser user = userRepository.findByUsername(username);
		Conversation conversation = new Conversation();
		
		supportCase.setCreationDate(new Date());
		supportCase.setUser(user);
		supportCase.setStatus("Respuesta");
		supportRepository.save(supportCase);
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		conversation.setMessageUser(formatter.format(date) + ": " + supportCase.getMessage());
		conversation.setSupportCase(supportCase);
		conversationRepository.save(conversation);
	}

	@Override
	public SupportCase findOne(int id) throws NoSupportCaseFoundException {
		SupportCase supportCase = supportRepository.findOne(id);
		
		if(supportCase == null)
			throw new NoSupportCaseFoundException();
		
		return supportRepository.findOne(id);
	}

	@Override
	@PreAuthorize("#supportCase.user.username == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(SupportCase supportCase) {
		supportRepository.delete(supportCase);
	}

	@Override
	public Object findByUsername(String username) {
		AppUser user = userRepository.findByUsername(username);		
		SupportCase supportCase = supportRepository.findByUser(user);
		
		if(supportCase != null) {
			List<Conversation> conversations = conversationRepository.findBySupportCase(supportCase);			
			supportCase.setConversations(conversations);
			user.setSupportCase(supportCase);
		}
		
		return user;
	}

	@Override
	public Object findFirstCreated() {
		Page<SupportCase> cases = supportRepository.findAll(new PageRequest(0, 20, Direction.ASC, "creationDate"));
		List<SupportCase> caseList = cases.getContent();
		
		return caseList;
	}

	@Override
	public Object findOneWithConversations(int id) throws NoSupportCaseFoundException {
		SupportCase supportCase = supportRepository.findOne(id);
		
		if(supportCase == null)
			throw new NoSupportCaseFoundException();
		
		List<Conversation> conversations = conversationRepository.findBySupportCase(supportCase);
		supportCase.setConversations(conversations);
		
		return supportCase;
	}
}

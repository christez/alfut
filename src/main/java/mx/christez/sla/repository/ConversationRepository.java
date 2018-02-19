package mx.christez.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.christez.sla.entity.Conversation;
import mx.christez.sla.entity.SupportCase;

public interface ConversationRepository extends JpaRepository<Conversation, Integer>{
	List<Conversation> findBySupportCase(SupportCase supportCase);
}

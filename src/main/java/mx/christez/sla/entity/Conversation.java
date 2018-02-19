package mx.christez.sla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Conversation {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "message_user")
	@Size(min = 1, max = 200, message = "El mensaje de usuario debe tener al menos 1 caracter y máximo 200")
	private String messageUser;
	
	@Column(name = "message_administrator")
	@Size(min = 1, max = 200, message = "El mensaje de administrador debe tener al menos 1 caracter y máximo 200")
	private String messageAdministrator;
	
	@ManyToOne
	@JoinColumn(name = "support_case_id")
	private SupportCase supportCase;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessageUser() {
		return messageUser;
	}

	public void setMessageUser(String messageUser) {
		this.messageUser = messageUser;
	}

	public String getMessageAdministrator() {
		return messageAdministrator;
	}

	public void setMessageAdministrator(String messageAdministrator) {
		this.messageAdministrator = messageAdministrator;
	}

	public SupportCase getSupportCase() {
		return supportCase;
	}

	public void setSupportCase(SupportCase supportCase) {
		this.supportCase = supportCase;
	}
}

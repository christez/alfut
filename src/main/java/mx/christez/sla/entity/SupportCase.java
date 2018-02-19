package mx.christez.sla.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class SupportCase {
	@OneToMany(mappedBy = "supportCase", cascade = CascadeType.REMOVE)
	private List<Conversation> conversations;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, max = 200, message = "El mensaje debe tener al menos 1 caracter y máximo 200")
	private String message;
	
	private String status;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private AppUser user;
	
	@Size(min = 1, message = "El título debe tener al menos 1 caracter")
	private String title;
	
	private String type;

	public List<Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(List<Conversation> conversations) {
		this.conversations = conversations;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

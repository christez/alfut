package mx.christez.sla.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Commercial {
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Size(min = 1, message = "Dirección inválida")
	@Email(message = "Dirección inválida")
	private String email;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, max = 500, message = "El mensaje debe tener al menos 1 caracter y máximo 500")
	private String message;
	
	@Size(min = 1, message = "Nombre inválido")
	private String name;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

package mx.christez.sla.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class New {
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Size(min = 1, message = "El encabezado debe tener al menos un caracter")
	private String header;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "La información debe tener al menos un caracter")
	private String information;
	
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private AppUser user;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}
}

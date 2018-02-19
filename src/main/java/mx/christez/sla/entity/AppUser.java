package mx.christez.sla.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class AppUser {
	@Size(min = 1, message = "Dirección inválida")
	@Email(message = "Dirección inválida")
	private String email;
	
	private boolean enabled;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "Apellido inválido")
	private String lastname;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<League> leagues;
	
	@Size(min = 1, message = "Nombre inválido")
	private String name;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<New> news;
	
	@Size(min = 5, message = "La contraseña debe tener al menos 5 caracteres")
	private String password;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@Column(name = "secret_answer")
	private String secretAnswer;
	
	@Column(name = "secret_question")
	private String secretQuestion;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
	private SupportCase supportCase;
	
	@Size(min = 3, max = 20, message = "El usuario debe tener al menos 3 caracteres y máximo 20")
	@Column(unique = true)
	private String username;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<New> getNews() {
		return news;
	}

	public void setNews(List<New> news) {
		this.news = news;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public SupportCase getSupportCase() {
		return supportCase;
	}

	public void setSupportCase(SupportCase supportCase) {
		this.supportCase = supportCase;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	
}

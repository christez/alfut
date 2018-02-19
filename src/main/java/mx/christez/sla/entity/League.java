package mx.christez.sla.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class League {
	@Size(min = 1, max = 200, message = "La información adicional debe tener al menos 1 caracteres y máximo 200")
	@Column(name = "additional_info")
	private String additionalInfo;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private double lattitud;
	
	private double longitud;
	
	@Size(min = 1, message = "El nombre debe tener al menos un caracter")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private AppUser user;
	
	@OneToMany(mappedBy = "league", cascade = CascadeType.REMOVE)
	private List<Tournament> tournaments;

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
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

	public double getLattitud() {
		return lattitud;
	}

	public void setLattitud(double lattitud) {
		this.lattitud = lattitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}
}

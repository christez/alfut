package mx.christez.sla.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class WorldLeague {
	@Column(name = "flag_url")
	private String flagUrl;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "El nombre debe tener al menos un caracter")
	private String name;
	
	@OneToMany(mappedBy = "league", cascade = CascadeType.REMOVE)
	private List<WorldTournament> tournaments;

	public String getFlagUrl() {
		return flagUrl;
	}

	public void setFlagUrl(String flagUrl) {
		this.flagUrl = flagUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WorldTournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<WorldTournament> tournaments) {
		this.tournaments = tournaments;
	}
}

package mx.christez.sla.entity;

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
public class WorldSchedule {
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE)
	private List<WorldMatch> matches;
	
	@Size(min = 1, message = "El nombre debe tener al menos un caracter")
	private String name;
	
	@Column(name = "text_for_matches", length = 1024)
	private String textForMatches;
	
	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private WorldTournament tournament;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<WorldMatch> getMatches() {
		return matches;
	}

	public void setMatches(List<WorldMatch> matches) {
		this.matches = matches;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTextForMatches() {
		return textForMatches;
	}

	public void setTextForMatches(String textForMatches) {
		this.textForMatches = textForMatches;
	}

	public WorldTournament getTournament() {
		return tournament;
	}

	public void setTournament(WorldTournament tournament) {
		this.tournament = tournament;
	}
}

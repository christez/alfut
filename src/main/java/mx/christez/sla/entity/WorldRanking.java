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
public class WorldRanking {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "El nombre debe tener al menos un caracter")
	private String name;
	
	@OneToMany(mappedBy = "ranking", cascade = CascadeType.REMOVE)
	private List<WorldTeam> teams;
	
	@Column(name = "text_for_teams", length = 1024)
	private String textForTeams;
	
	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private WorldTournament tournament;

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

	public List<WorldTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<WorldTeam> teams) {
		this.teams = teams;
	}

	public String getTextForTeams() {
		return textForTeams;
	}

	public void setTextForTeams(String textForTeams) {
		this.textForTeams = textForTeams;
	}

	public WorldTournament getTournament() {
		return tournament;
	}

	public void setTournament(WorldTournament tournament) {
		this.tournament = tournament;
	}
}

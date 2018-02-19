package mx.christez.sla.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class WorldTournament {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "league_id")
	private WorldLeague league;
	
	@Size(min = 1, message = "El nombre debe tener al menos un caracter")
	private String name;
	
	@OneToMany(mappedBy = "tournament", cascade = CascadeType.REMOVE)
	private List<WorldRanking> rankings;
	
	@OneToMany(mappedBy = "tournament", cascade = CascadeType.REMOVE)
	private List<WorldSchedule> schedules;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public WorldLeague getLeague() {
		return league;
	}

	public void setLeague(WorldLeague league) {
		this.league = league;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WorldRanking> getRankings() {
		return rankings;
	}

	public void setRankings(List<WorldRanking> rankings) {
		this.rankings = rankings;
	}

	public List<WorldSchedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<WorldSchedule> schedules) {
		this.schedules = schedules;
	}
}

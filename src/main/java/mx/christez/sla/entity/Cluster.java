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
public class Cluster {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "El nombre debe tener al menos un caracter")
	private String name;
	
	@OneToMany(mappedBy = "cluster", cascade = CascadeType.REMOVE)
	private List<Schedule> schedules;
	
	@Column(name = "schedule_generated")
	private boolean scheduleGenerated;
	
	@OneToMany(mappedBy = "cluster", cascade = CascadeType.REMOVE)
	private List<Team> teams;
	
	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;

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

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public boolean isScheduleGenerated() {
		return scheduleGenerated;
	}

	public void setScheduleGenerated(boolean scheduleGenerated) {
		this.scheduleGenerated = scheduleGenerated;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
}

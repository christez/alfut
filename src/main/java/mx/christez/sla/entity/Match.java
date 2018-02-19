package mx.christez.sla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Match {
	private String date;
	
	@Column(name = "goals_local")
	private int goalsLocal;
	
	@Column(name = "goals_visitor")
	private int goalsVisitor;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "playoff_id")
	private Playoff playoff;
	
	@ManyToOne
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;
	
	private String status;
	
	@Column(name = "team_local_id")
	private int teamLocalId;
	
	@Column(name = "team_local_name")
	private String teamLocalName;
	
	@Column(name = "team_visitor_id")
	private int teamVisitorId;
	
	@Column(name = "team_visitor_name")
	private String teamVisitorName;
	
	private String time;
	
	private String winner;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getGoalsLocal() {
		return goalsLocal;
	}

	public void setGoalsLocal(int goalsLocal) {
		this.goalsLocal = goalsLocal;
	}

	public int getGoalsVisitor() {
		return goalsVisitor;
	}

	public void setGoalsVisitor(int goalsVisitor) {
		this.goalsVisitor = goalsVisitor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Playoff getPlayoff() {
		return playoff;
	}

	public void setPlayoff(Playoff playoff) {
		this.playoff = playoff;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamLocalId() {
		return teamLocalId;
	}

	public void setTeamLocalId(int teamLocalId) {
		this.teamLocalId = teamLocalId;
	}

	public String getTeamLocalName() {
		return teamLocalName;
	}

	public void setTeamLocalName(String teamLocalName) {
		this.teamLocalName = teamLocalName;
	}

	public int getTeamVisitorId() {
		return teamVisitorId;
	}

	public void setTeamVisitorId(int teamVisitorId) {
		this.teamVisitorId = teamVisitorId;
	}

	public String getTeamVisitorName() {
		return teamVisitorName;
	}

	public void setTeamVisitorName(String teamVisitorName) {
		this.teamVisitorName = teamVisitorName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
}

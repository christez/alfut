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
public class Tournament {
	@OneToMany(mappedBy = "tournament", cascade = CascadeType.REMOVE)
	private List<Cluster> clusters;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Size(min = 1, message = "La descripción debe tener al menos un caracter")
	private String description;
	
	@Column(name = "games_played")
	private int gamesPlayed;
	
	@Column(name = "games_programmed")
	private int gamesProgrammed;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "league_id")
	private League league;
	
	@Size(min = 1, message = "El nombre debe tener al menos un caracter")
	private String name;
	
	@Column(name = "number_classified")
	private int numberClassified;
	
	@OneToMany(mappedBy = "tournament", cascade = CascadeType.REMOVE)
	private List<Playoff> playoffs;
	
	private String schema;
	
	@OneToMany(mappedBy = "tournament", cascade = CascadeType.REMOVE)
	private List<Schedule> schedules;
	
	@Column(name = "schedule_generated")
	private boolean scheduleGenerated;
	
	private String selection;
	
	private String status;
	
	@OneToMany(mappedBy = "tournament", cascade = CascadeType.REMOVE)
	private List<Team> teams;
	
	private String type;
	
	private String winner;

	public List<Cluster> getClusters() {
		return clusters;
	}

	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGamesProgrammed() {
		return gamesProgrammed;
	}

	public void setGamesProgrammed(int gamesProgrammed) {
		this.gamesProgrammed = gamesProgrammed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberClassified() {
		return numberClassified;
	}

	public void setNumberClassified(int numberClassified) {
		this.numberClassified = numberClassified;
	}

	public List<Playoff> getPlayoffs() {
		return playoffs;
	}

	public void setPlayoffs(List<Playoff> playoffs) {
		this.playoffs = playoffs;
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

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}
	
	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
}

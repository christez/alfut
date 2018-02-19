package mx.christez.sla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Team {
	@ManyToOne
	@JoinColumn(name = "cluster_id")
	private Cluster cluster;
	
	@Column(name = "games_drawed")
	private int gamesDrawed;
	
	@Column(name = "games_lost")
	private int gamesLost;
	
	@Column(name = "games_played")
	private int gamesPlayed;
	
	@Column(name = "games_won")
	private int gamesWon;
	
	@Column(name = "goals_against")
	private int goalsAgainst;
	
	@Column(name = "goals_difference")
	private int goalsDifference;
	
	@Column(name = "goals_favor")
	private int goalsFavor;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "El nombre debe tener al menos un caracter")
	private String name;
	
	private int points;
	
	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public int getGamesDrawed() {
		return gamesDrawed;
	}

	public void setGamesDrawed(int gamesDrawed) {
		this.gamesDrawed = gamesDrawed;
	}

	public int getGamesLost() {
		return gamesLost;
	}

	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public int getGoalsDifference() {
		return goalsDifference;
	}

	public void setGoalsDifference(int goalsDifference) {
		this.goalsDifference = goalsDifference;
	}

	public int getGoalsFavor() {
		return goalsFavor;
	}

	public void setGoalsFavor(int goalsFavor) {
		this.goalsFavor = goalsFavor;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
}

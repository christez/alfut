package mx.christez.sla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WorldTeam {
	@Column(name = "games_drawed")
	private String gamesDrawed;
	
	@Column(name = "games_lost")
	private String gamesLost;
	
	@Column(name = "games_played")
	private String gamesPlayed;
	
	@Column(name = "games_won")
	private String gamesWon;
	
	private String goals;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String points;
	
	private String position;
	
	@ManyToOne
	@JoinColumn(name = "ranking_id")
	private WorldRanking ranking;

	public String getGamesDrawed() {
		return gamesDrawed;
	}

	public void setGamesDrawed(String gamesDrawed) {
		this.gamesDrawed = gamesDrawed;
	}

	public String getGamesLost() {
		return gamesLost;
	}

	public void setGamesLost(String gamesLost) {
		this.gamesLost = gamesLost;
	}

	public String getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(String gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public String getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(String gamesWon) {
		this.gamesWon = gamesWon;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
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

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public WorldRanking getRanking() {
		return ranking;
	}

	public void setRanking(WorldRanking ranking) {
		this.ranking = ranking;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}

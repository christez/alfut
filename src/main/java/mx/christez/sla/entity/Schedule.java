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

@Entity
public class Schedule {
	@ManyToOne
	@JoinColumn(name = "cluster_id")
	private Cluster cluster;
	
	@Column(name = "games_played")
	private int gamesPlayed;
	
	@Column(name = "games_programmed")
	private int gamesProgrammed;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE)
	private List<Match> matches;
	
	@Column(name = "resting_team")
	private String restingTeam;
	
	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;
	
	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
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

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public String getRestingTeam() {
		return restingTeam;
	}

	public void setRestingTeam(String restingTeam) {
		this.restingTeam = restingTeam;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
}

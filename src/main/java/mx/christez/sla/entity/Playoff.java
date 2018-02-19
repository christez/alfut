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
public class Playoff {
	@Column(name = "games_played")
	private int gamesPlayed;
	
	@Column(name = "games_programmed")
	private int gamesProgrammed;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy = "playoff", cascade = CascadeType.REMOVE)
	private List<Match> matches;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
}

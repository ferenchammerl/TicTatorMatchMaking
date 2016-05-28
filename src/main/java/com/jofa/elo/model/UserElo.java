package com.jofa.elo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.jofa.match.model.TicMatch;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * UserElo generated by hbm2java
 */
@Entity
@Table(name = "user_elo", catalog = "db_match")
public class UserElo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private int elo;
	private int wins;
	private int losses;
	private int draws;
	private Set<TicMatch> matchesForLUsername = new HashSet<TicMatch>(0);
	private Set<TicMatch> matchesForWUsername = new HashSet<TicMatch>(0);

	public UserElo() {
	}
	public UserElo(String username, int elo, int wins, int losses, int draws) {
		this.username = username;
		this.elo = elo;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
	}

	public UserElo(String username, int elo, int wins, int losses, int draws, Set<TicMatch> ticMatchesForLUsername,
			Set<TicMatch> ticMatchesForWUsername) {
		this.username = username;
		this.elo = elo;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
		this.matchesForLUsername = ticMatchesForLUsername;
		this.matchesForWUsername = ticMatchesForWUsername;
	}

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "elo", nullable = false)
	public int getElo() {
		return this.elo;
	}

	public void setElo(int elo) {
		this.elo = elo;
	}

	@Column(name = "wins", nullable = false)
	public int getWins() {
		return this.wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public void incrementWins()
	{
		this.wins++;
	}
	
	@Column(name = "losses", nullable = false)
	public int getLosses() {
		return this.losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}
	public void incrementLosses()
	{
		this.losses++;
	}

	@Column(name = "draws", nullable = false)
	public int getDraws() {
		return this.draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}
	
	public void incrementDraws()
	{
		this.draws++;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userEloByLUsername")
	public Set<TicMatch> getTicMatchesForLUsername() {
		return this.matchesForLUsername;
	}

	public void setTicMatchesForLUsername(Set<TicMatch> ticMatchesForLUsername) {
		this.matchesForLUsername = ticMatchesForLUsername;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userEloByWUsername")
	public Set<TicMatch> getTicMatchesForWUsername() {
		return this.matchesForWUsername;
	}

	public void setTicMatchesForWUsername(Set<TicMatch> ticMatchesForWUsername) {
		this.matchesForWUsername = ticMatchesForWUsername;
	}

}

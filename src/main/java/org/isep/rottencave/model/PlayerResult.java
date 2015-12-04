package org.isep.rottencave.model;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="PlayerResult", 
uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class PlayerResult {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
	private int id;
	
	@Column(name="PlayDate", nullable=false)
	private Date playDate;
	
	@Column(name="Score", nullable=false)
	private int score;
	
	@Column(name="PlayerName", length=50, nullable=false)
	private String playerName;

	public PlayerResult() {
	
	}
	
	public PlayerResult(Date playDate, int score, String playerName) {
		this.playDate = playDate;
		this.score = score;
		this.playerName = playerName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPlayDate() {
		return playDate;
	}

	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}

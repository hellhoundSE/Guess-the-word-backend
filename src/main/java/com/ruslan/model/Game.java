package com.ruslan.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="game_id")
	private int id;

	
	@Column(name = "win")
	private boolean win;
	
    @ManyToOne
    @JoinColumn(name="Word_word_id")
	private Word word;

    @ManyToOne
    @JoinColumn(name="User_user_id")
	private User user;
	
	@Column(name="datatime")
	private Timestamp datetime;
    
    public Game(User user,Word word,boolean win) {
    	this.word = word;
    	this.user = user;
    	this.win = win;
    	datetime = new Timestamp(new java.util.Date().getTime());
    }
}

package com.ruslan.model;

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
@Table(name = "word")
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="word_id")
	private int id;
	
	@Column(name="word")
	private String word;
	
    @ManyToOne
    @JoinColumn(name="Language_language_id")
	private Language language;
    
    public Word(String word, Language language) {
    	this.word = word;
    	this.language = language;
    }
	
}

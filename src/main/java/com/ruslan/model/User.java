package com.ruslan.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="registration_datetime")
	private Timestamp registration_datetime;
	
	public User(String name) {
		this.name = name;
		registration_datetime = new Timestamp(new java.util.Date().getTime());
	}
}

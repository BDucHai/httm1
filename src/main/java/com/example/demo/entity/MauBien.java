package com.example.demo.entity;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="mauBien")
public class MauBien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="description")
	private String description;
	
	@Column (name ="url")
	private String url;
	
//	@Column (name ="createdAt")
//	private LocalDateTime createdAt;
	
//	@ManyToMany(mappedBy = "model", cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Set<Model> models = new HashSet<>();
	
	public MauBien() {
		// TODO Auto-generated constructor stub
	}
	

	public MauBien(int id, String description, String url ) {
	super();
	this.id = id;
	this.description = description;
	this.url = url;
//	this.createdAt = createdAt;
}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
}
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
@Table(name="nhanBien")
public class NhanBien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="nhan")
	private String nhan;
	
	
	
	public NhanBien() {
		// TODO Auto-generated constructor stub
	}



	public NhanBien(int id, String nhanbsx) {
		super();
		this.id = id;
		this.nhan = nhan;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNhan() {
		return nhan;
	}



	public void setNhanbsx(String nhan) {
		this.nhan = nhan;
	}
	
	
	
	
	
}

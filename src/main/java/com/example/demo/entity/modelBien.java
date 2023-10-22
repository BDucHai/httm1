package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modelBien")
public class modelBien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name = "path")
	private String path;
	
	@Column(name ="time")
	private float time;
	
	@Column(name ="acc")
	private float acc;
	
	@Column(name ="pre")
	private float pre;
	
	@Column(name ="recall")
	private float recall;
	
	@Column(name ="f1")
	private float f1;
	
	@Column(name = "active")
	private int active;
	
	public modelBien() {
		// TODO Auto-generated constructor stub
	}

	public modelBien(int id, String name, String path, float time, float acc, float pre, float recall, float f1,
			int active) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.time = time;
		this.acc = acc;
		this.pre = pre;
		this.recall = recall;
		this.f1 = f1;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public float getAcc() {
		return acc;
	}

	public void setAcc(float acc) {
		this.acc = acc;
	}

	public float getPre() {
		return pre;
	}

	public void setPre(float pre) {
		this.pre = pre;
	}

	public float getRecall() {
		return recall;
	}

	public void setRecall(float recall) {
		this.recall = recall;
	}

	public float getF1() {
		return f1;
	}

	public void setF1(float f1) {
		this.f1 = f1;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
}

package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.modelBien;

public interface modelBienRepository extends JpaRepository<modelBien, Integer>{
	modelBien findModelBienByActive(int active);
}

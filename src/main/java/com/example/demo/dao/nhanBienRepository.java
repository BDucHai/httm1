package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.NhanBien;

public interface nhanBienRepository extends JpaRepository<NhanBien, Integer>{
	Boolean existsByNhan(String nhan);
}

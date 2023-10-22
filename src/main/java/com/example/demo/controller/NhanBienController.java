package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.nhanBienRepository;

import com.example.demo.entity.NhanBien;

@CrossOrigin
@RestController
@RequestMapping("api/bien")
public class NhanBienController {
	@Autowired
	private nhanBienRepository nBien;
	
	@GetMapping("/getAllNhan")
	public ResponseEntity<?> getAllNhan(){
		List<NhanBien> nhans = nBien.findAll();
		return new ResponseEntity<>(nhans,HttpStatus.OK);
	}
	
	@PostMapping("/addNhan")
	public ResponseEntity<?> addNhan(@RequestBody NhanBien nhan){
		if(nhan.getNhan().equals("")) {
			return new ResponseEntity<>("Not found", HttpStatus.BAD_REQUEST); 
		}
		try {
			nBien.save(nhan);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@DeleteMapping("/deleteNhan/{id}")
	public ResponseEntity<?> deleteNhan(@PathVariable(value ="id") int id ){
		
		try {
			nBien.deleteById(id);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@PostMapping("/updateNhan/{id}")
	public ResponseEntity<?> updateNhan(@PathVariable(value="id") int id,@RequestBody NhanBien nhan){
		if(nhan.getNhan().equals("")) {
			return new ResponseEntity<>("Not found", HttpStatus.BAD_REQUEST); 
		}
		try {
			NhanBien n = nBien.findById(id).get();
			n.setNhanbsx(nhan.getNhan());
			nBien.save(n);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@GetMapping("/getNhan/{id}")
	public ResponseEntity<?> getNhan(@PathVariable (value="id") int id){
		NhanBien nhan = nBien.findById(id).get();
		return new ResponseEntity<>(nhan,HttpStatus.OK);
	}
	
	@GetMapping("/existNhan/{nhan}")
	public ResponseEntity<?> existsNhan(@PathVariable (value="nhan") String nhan){
		Boolean res = nBien.existsByNhan(nhan);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
}

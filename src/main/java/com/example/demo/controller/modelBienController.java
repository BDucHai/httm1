package com.example.demo.controller;


import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.modelBienRepository;
import com.example.demo.entity.MauBien;
import com.example.demo.entity.modelBien;

@RestController
@CrossOrigin
@RequestMapping("/api/bien")
public class modelBienController {
	
	@Autowired modelBienRepository modelBien;
	
	@GetMapping("/getAllModel")
	public ResponseEntity<?> getAll(){
		List<modelBien> models = modelBien.findAll();
		return new ResponseEntity<>(models, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteModel/{id}")
	public ResponseEntity<?> deleteModel(@PathVariable(value ="id") int id){
		try {
			modelBien.deleteById(id);
			return new ResponseEntity<>("OK", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addModel")
	public ResponseEntity<?> addModel(@RequestBody modelBien model){
		if(model.getName().equals("") || model.getPath().equals("")) {
			return new ResponseEntity<>("Not found", HttpStatus.BAD_REQUEST); 
		}
		try {
			model.setActive(0);
			modelBien.save(model);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@GetMapping("/activeModel/{id}")
	public ResponseEntity<?> activeModel(@PathVariable(value= "id") int id){
		modelBien model = modelBien.findModelBienByActive(1);
		modelBien res = modelBien.findById(id).get();
		model.setActive(0);
		res.setActive(1);
		modelBien.save(model);
		modelBien.save(res);
		return new ResponseEntity<>("OK",HttpStatus.OK);
	}
	
//	@GetMapping("/train")
//	public ResponseEntity<?> trainModel(){
//		//code lien ket train lay ket qua ve xong tra ve.
//		
//	}
	
}

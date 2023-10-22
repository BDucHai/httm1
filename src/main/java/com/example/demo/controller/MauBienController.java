package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils.Null;
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
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.dao.mauBienRepository;
import com.example.demo.entity.MauBien;


@CrossOrigin
@RestController
@RequestMapping("api/bien")
public class MauBienController {
	@Autowired
	private mauBienRepository mauBien;
	
	@GetMapping("/getAllMau")
	public ResponseEntity<?> getAllMau(){
		List<MauBien> maus = mauBien.findAll();
		return new ResponseEntity<>(maus,HttpStatus.OK);
	}
	
//	@PostMapping("/addMau")
//	public ResponseEntity<?> addMau(@RequestBody MauBien mau){
//		try {
//			mauBien.save(mau);
//			return new ResponseEntity<>("OK",HttpStatus.OK);
//		}catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST); 
//		}
//	}
	
	@PostMapping("/addMau")
	public ResponseEntity<?> addMau(@RequestParam(value = "description", required = false) String description,  @RequestParam(value = "file", required = false) MultipartFile file){
		if(description.equalsIgnoreCase("")|| file.isEmpty()) {
			return new ResponseEntity<>("Not found", HttpStatus.BAD_REQUEST); 
		}
		try {
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
		            "cloud_name", "dccekeplx",
		            "api_key", "581961351493346",
		            "api_secret", "-YF78yCCqWVxbAleF0jXOylj2gQ"
		        ));

			// Lấy dữ liệu hình ảnh từ MultipartFile
	        byte[] imageData = file.getBytes();
	        
	        MauBien m = new MauBien();
	     // Tải lên hình ảnh lên Cloudinary
	        try {
	            Map uploadResult = cloudinary.uploader().upload(imageData, ObjectUtils.emptyMap());
	            String imageUrl = (String) uploadResult.get("url");
	            m.setDescription(description);
	            m.setUrl(imageUrl);
	            mauBien.save(m);
	            return new ResponseEntity<>("OK",HttpStatus.OK);
	        } catch (Exception e) {
	        	return new ResponseEntity<>("Loi hinh anh", HttpStatus.BAD_REQUEST); 
	        }
	        
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@DeleteMapping("/deleteMau/{id}")
	public ResponseEntity<?> deleteMau(@PathVariable(value ="id") int id ){
		try {
			mauBien.deleteById(id);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@PostMapping("/updateMau/{id}")
	public ResponseEntity<?> updateMau(@PathVariable (value="id") int id,@RequestParam(value = "description", required = false) String description,  @RequestParam(value = "file", required = false) MultipartFile file){
		try {
			if( file!= null && !file.isEmpty()) {
				Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			            "cloud_name", "dccekeplx",
			            "api_key", "581961351493346",
			            "api_secret", "-YF78yCCqWVxbAleF0jXOylj2gQ"
			        ));

				// Lấy dữ liệu hình ảnh từ MultipartFile
		        byte[] imageData = file.getBytes();
		        
	            MauBien m = mauBien.findById(id).get();
		     // Tải lên hình ảnh lên Cloudinary
		        try {
		            Map uploadResult = cloudinary.uploader().upload(imageData, ObjectUtils.emptyMap());
		            String imageUrl = (String) uploadResult.get("url");

		            m.setDescription(description);
		            m.setUrl(imageUrl);
		            mauBien.save(m);
		            return new ResponseEntity<>("OK",HttpStatus.OK);
		        } catch (Exception e) {
		        	return new ResponseEntity<>("Loi hinh anh", HttpStatus.BAD_REQUEST); 
		        }
			}else {
				MauBien m = mauBien.findById(id).get();
				m.setDescription(description);
				mauBien.save(m);
				return new ResponseEntity<>("OK",HttpStatus.OK);
			}
	        
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@GetMapping("/getMau/{id}")
	public ResponseEntity<?> getMau(@PathVariable (value="id") int id){
		MauBien mau = mauBien.findById(id).get();
		return new ResponseEntity<>(mau,HttpStatus.OK);
	}
}

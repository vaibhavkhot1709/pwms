package com.pwms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pwms.entity.Student;
import com.pwms.service.StdServiceImpl;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pwstd")

public class StdController {

	private static  Logger logger= LogManager.getLogger(StdController.class);
	
	@Autowired
	StdServiceImpl serviceImpl;
	
	@PostMapping("/student")
	@Transactional
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		
		logger.info("This is info aout save Student");
		
		logger.error("Error at saveStudent Controller");
		
		return new ResponseEntity<>(serviceImpl.saveStudent(student), HttpStatus.CREATED);
	}
	
	@GetMapping("/student/{std_id}")
	@Transactional
	public ResponseEntity<Student> getStudentById(@PathVariable("std_id") int stdId){

		return new ResponseEntity<>(serviceImpl.getStudentById(stdId), HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){

		return ResponseEntity.ok(serviceImpl.getAllStudent());
	}
	
	@PutMapping("/student/{std_id}")
	@Transactional
	public ResponseEntity<Student> updateStudentById(@PathVariable("std_id") int stdId, @RequestBody Student newStudent){
			
		return ResponseEntity.ok(serviceImpl.updateStudentById(stdId, newStudent));
	}
	
	@DeleteMapping("/student/{std_id}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable("std_id") int stdId){
		serviceImpl.deletStundetById(stdId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/students")
	public ResponseEntity<Student> deleteAllStudets(){
				
		serviceImpl.deleteAllStudent();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}

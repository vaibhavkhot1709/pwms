package com.pwms.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
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
	
	private Logger logger=Logger.getLogger(StdController.class);
	{
		BasicConfigurator.configure();
	}
	
	
	@Autowired
	StdServiceImpl serviceImpl;
	
	@PostMapping("/student")
	@Transactional
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		
		logger.info("New Student added into DB");
		
		logger.error("Error at saveStudent Controller");
		
		return new ResponseEntity<>(serviceImpl.saveStudent(student), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/student/{std_id}")
	@Transactional
	public ResponseEntity<Student> getStudentById(@PathVariable("std_id") int stdId){

		logger.info("Fetching Student from DB");
		
		logger.error("Error at get Student Controller");
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
	
	@PostMapping("/students")
	public ResponseEntity<List<Student>> saveListOfStudents(@RequestBody List<Student> studentsList){
		
		List<Student> savedStudents = serviceImpl.saveListOfStudents(studentsList);
		
		return  new ResponseEntity<List<Student>>(savedStudents, HttpStatus.CREATED);

	}
	

	
}

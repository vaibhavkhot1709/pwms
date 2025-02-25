package com.pwms.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pwstd")

public class StdController {

	
	@Autowired
	StdServiceImpl serviceImpl;
	
	@PostMapping("/student")
	@Transactional
	public ResponseEntity<Student> saveStudent(@RequestBody @Valid Student student){
	
//		Student saveStudent= serviceImpl.saveStudent(student);
		return new ResponseEntity<>(serviceImpl.saveStudent(student), HttpStatus.CREATED);
	}
	
	@GetMapping("/student/{std_id}")
	@Transactional
	public ResponseEntity<Object> getStudentById(@PathVariable("std_id") int stdId){

		Student getStudent = serviceImpl.getStudentById(stdId);
		return new ResponseEntity<>(getStudent, HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		
//		List<Student> saveStudent = serviceImpl.getAllStudent();
//		return new ResponseEntity<>(saveStudent, HttpStatus.OK);
		return ResponseEntity.ok(serviceImpl.getAllStudent());
	}
	
	@PutMapping("/student/{std_id}")
	@Transactional
	public ResponseEntity<Map<String, Object>> updateStudentById(@PathVariable("std_id") int stdId, @RequestBody Student newStudent){

		 Map<String, Object> response = new HashMap();
		 
		 Student saveStudent = serviceImpl.getStudentById(stdId);
			
			if(saveStudent==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "Student with ID " + stdId + " is not found send valid Student ID"));
			}
			
		 
		Student updatedStd=serviceImpl.updateStudentById(stdId, newStudent);
		
		response.put("message", "Student with id "+ stdId+" is updated");
		response.put("update student", updatedStd);
	
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/student/{std_id}")
	public ResponseEntity deleteStudentById(@PathVariable("std_id") int stdId){
		Student saveStudent = serviceImpl.getStudentById(stdId);
		
		if(saveStudent==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "Student with ID " + stdId + " is not found send valid Student ID"));
		}
		serviceImpl.deletStundetById(stdId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/students")
	public ResponseEntity deleteAllStudets(){
				
		serviceImpl.deleteAllStudent();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}

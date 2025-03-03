package com.pwms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pwms.entity.Student;
import com.pwms.repository.StdRepo;

import jakarta.transaction.Transactional;


@Component
public class StdDaoImpl implements StdDao{

	@Autowired
	StdRepo stdRepo;
	@Override
	public Student saveStudent(Student student) {
//		return stdRepo.save(student);
		
		return stdRepo.save(student);
	}

	@Override
	public Student getStudentById(int stdId) {
		return stdRepo.getReferenceById(stdId);
//		System.out.println("inside daoimpl get");
//		Student getStd=stdRepo.findById(stdId)
//				.orElseThrow(()-> new StudentNotFoundException("Student with Id "+stdId+" is not present"));
//		return getStd;
	}

	@Override
	public List<Student> getAllStudent() {
		return stdRepo.findAll();
	}

	

	@Override
	public void deletStundetById(int stdId) {
		stdRepo.deleteById(stdId);	
	}

	@Override
	public void deleteAllStudent() {
		stdRepo.deleteAll();
	}

	@Override
	@Transactional
	public Student updateStudentById(int stdId, Student updatedStudent) {
				
		Student upStd= stdRepo.save(updatedStudent);
		return upStd;
	}

	@Override
	public List<Integer> getListOfAllIds() {
//		return stdRepo.findAll()
//                .stream()
//                .map(Student::getStudentId)
//                .toList();
		
		return null;
	}


}

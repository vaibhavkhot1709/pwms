package com.pwms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwms.dao.StdDaoImpl;
import com.pwms.entity.Student;
import com.pwms.exceptions.StudentNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class StdServiceImpl implements StdService{

	@Autowired
	StdDaoImpl daoImpl;
	@Override
	public Student saveStudent(Student student) {
		return daoImpl.saveStudent(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return daoImpl.getAllStudent();
	}

	

	@Override
	public void deletStundetById(int stdId) {
//		List<Integer> stdList = getListOfAllIds();
		Student stdDel=null;
		for (Integer id : getListOfAllIds()) {
			System.out.println(id==stdId);
	        if (id==stdId) {
	        	stdDel=daoImpl.getStudentById(stdId);
	            break;  
	        }
	    }
		if (stdDel==null) {
			throw new StudentNotFoundException("Student with Id "+stdId+" is not present");
	    }
		daoImpl.deletStundetById(stdId);	
	}

	@Override
	public void deleteAllStudent() {
		daoImpl.deleteAllStudent();
	}

	@Override
	@Transactional
	public Student updateStudentById(int stdId, Student newStudent) {
		
//		List<Integer> stdList = getListOfAllIds();
		//-------------------
		
//		Student existingStudent = null;
//		
//		for (Integer id : getListOfAllIds()) {
//			System.out.println(id==stdId);
//	        if (id==stdId) {
//	        	existingStudent = new Student();
//	        	existingStudent.setStdId(stdId);
//	        	existingStudent.setFirstName(newStudent.getFirstName());
//	    	    existingStudent.setLastName(newStudent.getLastName());
//	    	    existingStudent.setContct(newStudent.getContct());
//	    	    existingStudent.setEmail(newStudent.getEmail());
//	    	    existingStudent.setAddress(newStudent.getAddress());
//	    	    
//	            break;  
//	        }
//	    }
//		
//		if (existingStudent==null) {
//			throw new StudentNotFoundException("Student with Id "+stdId+" is not present");
//	    }
		
		//-----------------
		int idd=0;
		for (Integer id : getListOfAllIds()) {
			System.out.println(id==stdId);
	        if (id==stdId) {	    	    
	            idd=1;  
	        }
	    }
		
		if (idd != 1) {
	        throw new StudentNotFoundException("Student with Id "+stdId+" is not present");
	    }
		
		return daoImpl.updateStudentById(stdId, newStudent);
	}

	@Override
	public  List<Integer> getListOfAllIds() {
		List<Student> stdList = daoImpl.getAllStudent();
		
		List<Integer>stdL=stdList.stream().map(Student:: getStdId).collect(Collectors.toList());
		
		return stdL;
	}
	

	@Override
	public Student getStudentById(int stdId) {
		
		int idd=0;
		for (Integer id : getListOfAllIds()) {
			System.out.println(id==stdId);
	        if (id==stdId) {	    	    
	            idd=1;  
	        }
	    }
		
		if (idd != 1) {
	        throw new StudentNotFoundException("Student with Id "+stdId+" is not present");
	    }
		return daoImpl.getStudentById(stdId);

	}
	


}

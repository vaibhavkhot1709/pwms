package com.pwms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwms.dao.StdDaoImpl;
import com.pwms.entity.Student;
import com.pwms.exceptions.EmptyFieldsInJson;
import com.pwms.exceptions.IdMustBeInteger;
import com.pwms.exceptions.StudentNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class StdServiceImpl implements StdService{

	@Autowired
	StdDaoImpl daoImpl;
	@Override
	public Student saveStudent(Student student) {
		
		if(student.getFirstName()==" " || student.getLastName()==" " || student.getContct()==" " || student.getAddress().getBuildingName()==" ") {
			
			throw new EmptyFieldsInJson("Pass Valid JSON");
		}
		return daoImpl.saveStudent(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return daoImpl.getAllStudent();
	}

	

	@Override
	public void deletStundetById(int stdId) {
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
		newStudent.setStdId(stdId);
		
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
		
		if (stdId<0) {
	        throw new IdMustBeInteger("Id must be an Integer having positive value. Pass valid ID");
	    }
		
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

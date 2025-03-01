package com.pwms.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pwms.dao.StdDaoImpl;
import com.pwms.entity.Address;
import com.pwms.entity.Student;
import com.pwms.repository.StdRepo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(MockitoExtension.class)
public class StdServiceImplTest {
	
	@Mock
	StdRepo repo;
	
	@InjectMocks
	StdDaoImpl stdDaoImpl;
	
	@Test
	void saveStudent() {
		log.info(("this is unit test for saveStudent"));
		
  		Student student=new Student();
		Address address=new Address();
		address.setBuildingName("Shyam Palace");
		address.setPinNum(121212);
		
		student.setFirstName("XYZ");
		student.setLastName("Mon");
		student.setContct("1234");
		student.setEmail("xm@gmail.com");
		student.setAddress(address);
	
		
		Mockito.when(repo.save(student)).thenReturn(student);
		Student addStudent= stdDaoImpl.saveStudent(student);
		
		Assertions.assertNotNull(addStudent);
		Assertions.assertEquals(student.getStdId(), addStudent.getStdId());
		 
		System.out.println("save completed !");
	}
	
	
	void getStudent() {
		
	}
	

}

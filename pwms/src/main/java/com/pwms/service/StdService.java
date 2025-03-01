package com.pwms.service;

import java.util.List;

import com.pwms.entity.Student;

public interface StdService {
	
	public Student saveStudent(Student Student);
	public Student getStudentById(int stdId);
	public List<Student> getAllStudent();
	public void deletStundetById(int stdId);
	public void deleteAllStudent();
	
	public Student updateStudentById(int stdId,Student Student);
	
	public List<Integer> getListOfAllIds();
	
	public List<Student> saveListOfStudents(List<Student> list);
	
	public boolean checkStudentExist(Student student);
	
	public  List<String> getListOfAllEmails() ;

}

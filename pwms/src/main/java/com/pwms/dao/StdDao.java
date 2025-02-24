package com.pwms.dao;

import java.util.List;

import com.pwms.entity.Student;

public interface StdDao {
	
	public Student saveStudent(Student Student);
	public Student getStudentById(int stdId);
	public List<Student> getAllStudent();
	public void deletStundetById(int stdId);
	public void deleteAllStudent();
	
	public Student updateStudentById(int stdId,Student Student);
	
	public List<Integer> getListOfAllIds();

}

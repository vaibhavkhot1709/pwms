package com.pwms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pwms.entity.Student;



public interface StdRepoTest extends JpaRepository<Student, Integer> {

}
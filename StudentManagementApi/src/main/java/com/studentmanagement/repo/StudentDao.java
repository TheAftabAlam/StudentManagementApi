package com.studentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entity.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
	
	public Student findBystudentName(String studentName);
}

package com.studentmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entity.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
	
	public List<Student> findBystudentName(String studentName);
}

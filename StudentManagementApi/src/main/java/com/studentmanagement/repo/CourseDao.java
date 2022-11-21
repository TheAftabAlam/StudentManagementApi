package com.studentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entity.Course;
@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {

	public Course  findBycourseName(String courseName);
}

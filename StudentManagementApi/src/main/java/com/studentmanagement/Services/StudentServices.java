package com.studentmanagement.Services;

import java.util.List;

import com.studentmanagement.Exception.AdminException;
import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.Student;

public interface StudentServices {
	
	public Student updateProfile(Student student) throws AdminException;
	
	public List<Course> getCourses(Integer id) throws AdminException;
	
	public Student leaveCourse(String  courseName, Integer studentId) throws AdminException;

}

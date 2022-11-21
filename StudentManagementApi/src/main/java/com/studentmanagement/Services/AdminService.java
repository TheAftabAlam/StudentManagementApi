package com.studentmanagement.Services;

import com.studentmanagement.entity.Admin;
import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.Student;


public interface AdminService {

	public String SignUp(Admin admin) throws Exception;
	
	public Student addStudent(Student student,String key) throws Exception;
	public Course addCourse(Course course,String key)throws Exception;
	public Student assignCourse(String courseName,String studentName,String key) throws Exception;
}

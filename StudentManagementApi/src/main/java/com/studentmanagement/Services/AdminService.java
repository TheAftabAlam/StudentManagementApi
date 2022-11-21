package com.studentmanagement.Services;

import java.util.List;

import com.studentmanagement.Exception.AdminException;
import com.studentmanagement.entity.Admin;
import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.Student;


public interface AdminService {

	public String SignUp(Admin admin) throws AdminException;
	
	public Student addStudent(Student student,String key) throws AdminException;
	public Course addCourse(Course course,String key)throws AdminException;
	public Course assignCourse(Integer courseId,Integer studentId,String key) throws AdminException;
	public List<Student> getStudentByName(String name,String key) throws AdminException;
	public List<Student> getStudentByCourseName(String courseName,String key) throws AdminException;
}

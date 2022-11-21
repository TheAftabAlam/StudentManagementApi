package com.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.Services.AdminService;
import com.studentmanagement.entity.Admin;
import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.Student;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> SignUpHandler(@RequestBody Admin admin) throws Exception
	{
	 String admin2=	adminService.SignUp(admin);
	 
	 return new ResponseEntity<String>(admin2,HttpStatus.CREATED);
	 
	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student student, @RequestParam(required = false) String key) throws Exception
	{
		Student student2= adminService.addStudent(student, key);
		
		return new ResponseEntity<Student>(student2,HttpStatus.CREATED);
	}
	
	@PostMapping("/addcourse")
	public ResponseEntity<Course> addCourseHandler(@RequestBody Course course, @RequestParam(required = false) String key) throws Exception
	{
		Course course2= adminService.addCourse(course, key);
		
		return new ResponseEntity<Course>(course2,HttpStatus.CREATED);
	}
	
	@PostMapping("/assigncourse/{cName}/{sName}")
	public ResponseEntity<Student> assigncourseHandler(@PathVariable("cName") String courseName ,@PathVariable("sName") String studentName, @RequestParam(required = false) String key) throws Exception
	{
		Student str= adminService.assignCourse(courseName, studentName,key);
		
		return new ResponseEntity<Student>(str,HttpStatus.CREATED);
	}
	

	
	
	
	
	

}

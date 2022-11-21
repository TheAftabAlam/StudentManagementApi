package com.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.Exception.AdminException;
import com.studentmanagement.Services.StudentServices;
import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentServices studentServices;
	@PostMapping("/update")
	public ResponseEntity<Student> updateProfileHandler(@RequestBody Student student) throws AdminException
	{
		Student student2= studentServices.updateProfile(student);
		
		return new ResponseEntity<Student>(student2,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getCourse/{id}")
	public ResponseEntity<List<Course>> getCoursesHandler(@PathVariable("id") Integer id) throws AdminException
	{
		List<Course> courses= studentServices.getCourses(id);
		
		return new  ResponseEntity<List<Course>>(courses,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/leaveCourse/{cName}/{sID}")
	public ResponseEntity<Student> leaveCoursesHandler(@PathVariable("cName") String cname,@PathVariable("sID") Integer id) throws AdminException
	{
		Student student= studentServices.leaveCourse(cname, id);
		
		return new  ResponseEntity<Student>(student,HttpStatus.ACCEPTED);
	}
	
	
	
	
	

}

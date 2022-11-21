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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.Exception.AdminException;
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
	public ResponseEntity<String> SignUpHandler(@RequestBody Admin admin) throws AdminException
	{
	 String admin2=	adminService.SignUp(admin);
	 
	 return new ResponseEntity<String>(admin2,HttpStatus.CREATED);
	 
	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student student, @RequestParam(required = false) String key) throws AdminException
	{
		Student student2= adminService.addStudent(student, key);
		
		return new ResponseEntity<Student>(student2,HttpStatus.CREATED);
	}
	
	@PostMapping("/addcourse")
	public ResponseEntity<Course> addCourseHandler(@RequestBody Course course, @RequestParam(required = false) String key) throws AdminException
	{
		Course course2= adminService.addCourse(course, key);
		
		return new ResponseEntity<Course>(course2,HttpStatus.CREATED);
	}
	
	@PostMapping("/assigncourse/{cID}/{sID}")
	public ResponseEntity<Course> assigncourseHandler(@PathVariable("cID") Integer courseId ,@PathVariable("sID") Integer studentId, @RequestParam(required = false) String key) throws AdminException
	{
		Course str= adminService.assignCourse(courseId,studentId,key);
		
		return new ResponseEntity<Course>(str,HttpStatus.CREATED);
	}
	
	@GetMapping("/getstudents/{name}")
	public ResponseEntity<List<Student>> getStudentsHandler(@PathVariable("name") String name,@RequestParam(required = false) String key) throws AdminException
	{
		List<Student> students= adminService.getStudentByName(name, key);
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getstudentsByCourseName/{name}")
	public ResponseEntity<List<Student>> getStudentsByCourseNameHandler(@PathVariable("name") String name,@RequestParam(required = false) String key) throws AdminException
	{
		List<Student> students= adminService.getStudentByCourseName(name, key);
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.ACCEPTED);
	}
	 

	
	
	
	
	

}

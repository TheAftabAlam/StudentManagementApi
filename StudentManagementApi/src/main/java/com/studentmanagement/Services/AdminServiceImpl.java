package com.studentmanagement.Services;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.entity.Address;
import com.studentmanagement.entity.Admin;
import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.CurrentAdminSession;
import com.studentmanagement.entity.Student;

import com.studentmanagement.repo.AdminDao;
import com.studentmanagement.repo.CourseDao;
import com.studentmanagement.repo.SessionDao;
import com.studentmanagement.repo.StudentDao;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private CourseDao courseDao;
	
	

	@Override
	public String SignUp(Admin admin) throws Exception {
		
		Admin existAdmin= adminDao.findByadminEmail(admin.getAdminEmail());
		if(existAdmin!=null)
		{
			throw new Exception("Admin already exist!");
		}
		else
		{
			 adminDao.save(admin);
			 return "Admin SignUp Successfull";
		}
		
		
	}




	@Override
	public Student addStudent(Student student, String key) throws Exception {
		CurrentAdminSession currentAdminSession= sessionDao.findByuuid(key);
		if(currentAdminSession==null)
			throw new Exception("Admin login first");
		List<Address> addresses=student.getAddress();
		for(Address address : addresses)
			address.setStudent(student);
		
			
		
		return studentDao.save(student);
	}




	@Override
	public Course addCourse(Course course, String key) throws Exception {
		CurrentAdminSession currentAdminSession= sessionDao.findByuuid(key);
		if(currentAdminSession==null)
			throw new Exception("Admin login first");
		List<Student> students= course.getStudents();
		for(Student student:students)
			student.getCourses().add(course);
		return courseDao.save(course);
	}




	@Override
	public Student assignCourse(String courseName, String studentName,String key) throws Exception {
		
		CurrentAdminSession currentAdminSession= sessionDao.findByuuid(key);
		if(currentAdminSession==null)
			throw new Exception("Admin login first");
		
		
		Course course= courseDao.findBycourseName(courseName);
		if(course==null)
			throw new Exception("Course not registered with this name");
		Student student =studentDao.findBystudentName(studentName);
		if(student==null)
			throw new Exception("Student not registered with this name");
		List<Course> courses=student.getCourses();
		
		for(Course course2:courses)
			course2.getStudents().add(student);
		courseDao.save(course);
		
//		
//		List<Student> students=course.getStudents();
//		for(Student st:students)
//			st.getCourses().add(course);
//		
		studentDao.save(student);
//		
		return student;
	}

	

	
	
}

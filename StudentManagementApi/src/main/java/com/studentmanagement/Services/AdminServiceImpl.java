package com.studentmanagement.Services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.Exception.AdminException;
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
	public String SignUp(Admin admin) throws AdminException {
		
		Admin existAdmin= adminDao.findByadminEmail(admin.getAdminEmail());
		if(existAdmin!=null)
		{
			throw new AdminException("Admin already exist!");
		}
		else
		{
			 adminDao.save(admin);
			 return "Admin SignUp Successfull";
		}
		
		
	}




	@Override
	public Student addStudent(Student student, String key) throws AdminException {
		CurrentAdminSession currentAdminSession= sessionDao.findByuuid(key);
		if(currentAdminSession==null)
			throw new AdminException("Admin login first");
		List<Address> addresses=student.getAddress();
		for(Address address : addresses)
			address.setStudent(student);
		
			
		
		return studentDao.save(student);
	}




	@Override
	public Course addCourse(Course course, String key) throws AdminException {
		CurrentAdminSession currentAdminSession= sessionDao.findByuuid(key);
		if(currentAdminSession==null)
			throw new AdminException("Admin login first");
		List<Student> students= course.getStudents();
		for(Student student:students)
			student.getCourses().add(course);
		return courseDao.save(course);
	}




	@Override
	public Course assignCourse(Integer courseId,Integer studentId,String key) throws AdminException {
		
		CurrentAdminSession currentAdminSession= sessionDao.findByuuid(key);
		if(currentAdminSession==null)
			throw new AdminException("Admin login first");
		
		
		Optional<Course> courseoOptional= courseDao.findById(courseId);
		if(!courseoOptional.isPresent())
			throw new AdminException("Course not registered with this name");
		Optional<Student> studentoOptional =studentDao.findById(studentId);
		if(!studentoOptional.isPresent())
			throw new AdminException("Student not registered with this name");
		Course course=courseoOptional.get();
		Student student=studentoOptional.get();
		
		course.getStudents().add(student);
		student.getCourses().add(course);
		studentDao.save(student);
		
		return course;
	}




	@Override
	public List<Student> getStudentByName(String name,String key) throws AdminException {

		CurrentAdminSession currentAdminSession= sessionDao.findByuuid(key);
		if(currentAdminSession==null)
			throw new AdminException("Admin login first");
		List<Student> students= studentDao.findBystudentName(name);
		if(students.size()==0)
			throw new AdminException("List is empty");
		return students;
	}




	@Override
	public List<Student> getStudentByCourseName(String courseName, String key) throws AdminException {
		CurrentAdminSession currentAdminSession= sessionDao.findByuuid(key);
		if(currentAdminSession==null)
			throw new AdminException("Admin login first");
		Course course= courseDao.findBycourseName(courseName);
		
		return course.getStudents();
		
	}

	

	
	
}

package com.studentmanagement.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.Exception.AdminException;
import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.Student;
import com.studentmanagement.repo.StudentDao;
@Service
public class StudentServiceImpl implements StudentServices{
	
	@Autowired
	private StudentDao studentDao;
	

	@Override
	public Student updateProfile(Student student) throws AdminException {
		
		Optional<Student> stOptional= studentDao.findById(student.getStudentId());
		if(stOptional.isPresent())
		{
			return studentDao.save(student);
		}
		else {
			throw new AdminException("Student not exist");
		}
	}


	@Override
	public List<Course> getCourses(Integer id) throws AdminException {
		Optional<Student> stOptional= studentDao.findById(id);
		if(stOptional.isPresent())
		{
			return stOptional.get().getCourses();
		}
		else {
			throw new AdminException("student not exist");
		}
	}


	@Override
	public Student leaveCourse(String courseName,Integer sId) throws AdminException {
		Optional<Student> student= studentDao.findById(sId);
		if(student.isPresent())
		{
			
			student.get().getCourses().remove(courseName);
			
			return student.get();
					
		}
		else {
			throw new AdminException("student not exist");
		}
	}

}

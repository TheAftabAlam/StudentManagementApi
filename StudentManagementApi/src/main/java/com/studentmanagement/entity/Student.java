package com.studentmanagement.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


import lombok.Data;
import net.bytebuddy.utility.RandomString;
@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	private String studentName;
	private Date dobDate;
	private String gender;
	
	private String unique_student_code=RandomString.make(5);
	
	
	@OneToMany(cascade =  CascadeType.ALL,mappedBy = "student")
	private List<Address> address=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
	private List<Course> courses=new ArrayList<>();

}

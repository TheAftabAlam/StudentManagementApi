package com.studentmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	private String courseName;
	private String descripton;
	private String courseType;
	private String duration;
	
	private String topics;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Student> students=new ArrayList<>();
	
}

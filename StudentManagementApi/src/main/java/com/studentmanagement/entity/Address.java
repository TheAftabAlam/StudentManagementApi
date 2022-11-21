package com.studentmanagement.entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String area;
	private String state;
	private String district;
	private String pincode;
	private String addressType;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Student student;
	
	
}

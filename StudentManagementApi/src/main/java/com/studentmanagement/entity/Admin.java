package com.studentmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String adminName;
	private String adminEmail;
	private String mobileNumber;
	private String password;

}

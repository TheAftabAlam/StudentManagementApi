package com.studentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entity.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{
	
	public Admin findByadminEmail(String adminEmail);
	

}

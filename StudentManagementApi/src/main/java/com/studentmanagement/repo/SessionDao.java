package com.studentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entity.CurrentAdminSession;
@Repository
public interface SessionDao extends JpaRepository<CurrentAdminSession, Integer>{

	 public CurrentAdminSession findByuuid(String uuid);
	
	
}

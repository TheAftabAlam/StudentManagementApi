package com.studentmanagement.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CurrentAdminSession {
	
	@Id
	private Integer adminSessionId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

}

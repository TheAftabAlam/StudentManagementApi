package com.studentmanagement.Services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.entity.Admin;
import com.studentmanagement.entity.AdminLoginDTO;
import com.studentmanagement.entity.CurrentAdminSession;
import com.studentmanagement.repo.AdminDao;
import com.studentmanagement.repo.SessionDao;

import net.bytebuddy.utility.RandomString;
@Service
public class LoginServicesImpl implements LoginServices{

	@Autowired
	private AdminDao adminDao;
	
	
	@Autowired
	private SessionDao sessionDao;
	
	
	
	
	
	@Override
	public String logIntoAccount(AdminLoginDTO dto) throws Exception {
		Admin eAdmin= adminDao.findByadminEmail(dto.getEmail());
		//System.out.println(eAdmin);
		if(eAdmin==null)
			throw new Exception("admin not registered with this email!");
		
		Optional<CurrentAdminSession> optional = sessionDao.findById(eAdmin.getId());
		
		if(optional.isPresent())
			throw new Exception("admin already logged in");
		
		if(eAdmin.getPassword().equals(dto.getPassword()))
		{
			CurrentAdminSession currentAdminSession=new CurrentAdminSession();
			currentAdminSession.setAdminSessionId(eAdmin.getId());
			currentAdminSession.setLocalDateTime(LocalDateTime.now());
			String key= RandomString.make(6);
			currentAdminSession.setUuid(key);
			sessionDao.save(currentAdminSession);
			
			return "Login successfull with key "+key;
		}
		else {
			throw new Exception("Please enter valid password");
		}
		
		
		
	}

	@Override
	public String logOutFromAccount(String key) throws Exception {
		CurrentAdminSession currentAdminSession= sessionDao.findByuuid(key);
		if(currentAdminSession==null)
			throw new Exception("Please login first");
		sessionDao.delete(currentAdminSession);
		return "Logout successfull";
	}
	

}

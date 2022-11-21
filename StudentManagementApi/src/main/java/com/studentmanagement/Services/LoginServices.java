package com.studentmanagement.Services;



import com.studentmanagement.entity.AdminLoginDTO;



public interface LoginServices {

	public String logIntoAccount(AdminLoginDTO dto)throws Exception;

	public String logOutFromAccount(String key)throws Exception;
}

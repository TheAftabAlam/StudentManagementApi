
package com.studentmanagement.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.studentmanagement.Services.LoginServices;
import com.studentmanagement.entity.AdminLoginDTO;

@RestController

public class LoginController {

	@Autowired
	private LoginServices customerLogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestBody AdminLoginDTO dto) throws Exception {
		
		String result = customerLogin.logIntoAccount(dto);
		

		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@PostMapping("/logout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws Exception {
		return customerLogin.logOutFromAccount(key);
		
	}
	
	
	
}

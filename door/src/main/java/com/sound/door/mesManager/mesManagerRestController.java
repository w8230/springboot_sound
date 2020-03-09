package com.sound.door.mesManager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sound.door.Common.Interceptor.UserData;

@RestController
public class mesManagerRestController {

	@Autowired
	private mesManagerService managerSerive;
	
	@GetMapping("/validUser")
	public int validUser(UserData userData, HttpServletRequest request) {
		return managerSerive.validUser(userData,request);
	}
}

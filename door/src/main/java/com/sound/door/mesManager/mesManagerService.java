package com.sound.door.mesManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.door.Common.Interceptor.UserData;
import com.sound.door.Mapper.mesManager.mesManaerMapper;

@Service
public class mesManagerService {
	
	@Autowired
	private mesManaerMapper managerMapper;

	public int validUser(UserData userData, HttpServletRequest request) {
		UserData data = new UserData();
		HttpSession session = request.getSession();
	    data = managerMapper.getUserData(userData);
	    session.setAttribute("userData", data);
		return managerMapper.validUser(userData);
	}
}

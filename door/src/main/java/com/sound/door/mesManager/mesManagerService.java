package com.sound.door.mesManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.door.Common.Interceptor.UserData;
import com.sound.door.Mapper.mesManager.mesManaerMapper;

@Service
public class mesManagerService {
	
	@Autowired
	private mesManaerMapper managerMapper;

	public int validUser(UserData userData) {
		return managerMapper.validUser(userData);
	}
}

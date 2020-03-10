package com.sound.door.mesManager.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.door.Mapper.mesManager.Auth.MesAuthMapper;

@Service
public class MesAuthService {
	@Autowired
	private MesAuthMapper authMapper;

}

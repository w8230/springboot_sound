package com.sound.door.mesManager.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MesAuthRestController {
	@Autowired
	private MesAuthService authService;

}

package com.sound.door.Common.Various;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.mesManager.Auth.DTO.SYSAuthProgram;

@RestController
public class VariousRestController {
	@Autowired
	private VariousService service;
	
	
	@RequestMapping(value ="/menuAuthGet", method = RequestMethod.POST)
    public SYSAuthProgram menuAuthGet(HttpServletRequest req, Page p) { return service.menuAuthGet(req,p); 
	}

}

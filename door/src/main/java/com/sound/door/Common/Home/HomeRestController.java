package com.sound.door.Common.Home;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sound.door.mesManager.DTO.SYSDept;


@RestController
public class HomeRestController {
	@Autowired 
	HomeService homeService;
	
	 @RequestMapping(value = "/sysDeptGet")
	    public List<SYSDept> sysDeptGet() {
	        return homeService.sysDeptGet();
	    }
	  
}

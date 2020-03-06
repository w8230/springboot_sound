package com.sound.door.Common;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
	@Autowired HomeService homeService;
	
	 @RequestMapping(value = "/sysDeptGet", method = RequestMethod.POST)
	    public List<SYSDept> sysDeptGet() {
	        return homeService.sysDeptGet();
	    }
	  
}

package com.sound.door.mesManager.Auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sound.door.Common.DataTransferObject.Message;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.DataTransferObject.RESTful;
import com.sound.door.mesManager.Auth.DTO.SYSAuth;

@RestController
public class MesAuthRestController {
	@Autowired
	private MesAuthService authService;
	
	
	@RequestMapping(value="/sysAuthGet" , method = RequestMethod.POST)
    public RESTful sysAuthGet(HttpServletRequest req, Page p){
        return authService.sysAuthGet(req, p);
    }

    @RequestMapping(value="/sysAuthOneGet" , method = RequestMethod.POST)
    public SYSAuth sysAuthOneGet(HttpServletRequest req, Page p){
        return authService.sysAuthOneGet(req, p);
    }

    @RequestMapping(value="/sysAuthAdd" , method = RequestMethod.POST)
    public  Message sysAuthAU(HttpServletRequest request, SYSAuth sysAuth){
        return authService.sysAuthAU(request, sysAuth);
    }

    @RequestMapping(value="/sysAuthDelete" , method = RequestMethod.POST)
    public Message sysAuthDelete(Page p , HttpServletRequest req){
        return authService.sysAuthDelete(p,req);
    }
	
	

}

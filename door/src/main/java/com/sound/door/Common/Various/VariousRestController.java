package com.sound.door.Common.Various;

import javax.servlet.http.HttpServletRequest;

import com.sound.door.mesManager.Master.DTO.SYS_COMMON_CD;
import com.sound.door.mesManager.User.DTO.SYS_DEPT_CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.mesManager.Auth.DTO.SYSAuthProgram;

import java.util.List;

@RestController
public class VariousRestController {
	@Autowired
	private VariousService service;
	
	
	@RequestMapping(value ="/menuAuthGet", method = RequestMethod.POST)
    public SYSAuthProgram menuAuthGet(HttpServletRequest req, Page p) { return service.menuAuthGet(req,p); 
	}

	@RequestMapping(value ="/sysDeptAllGet", method = RequestMethod.POST)
	public List<SYS_DEPT_CD> sysDeptAllGet(HttpServletRequest req, Page p) { return service.sysDeptAllGet(req,p);
	}

	@RequestMapping(value ="/sysCommonAllGet", method = RequestMethod.POST)
	public List<SYS_COMMON_CD> sysCommonAllGet(HttpServletRequest req, Page p) { return service.sysCommonAllGet(req,p);
	}
}

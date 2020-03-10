package com.sound.door.mesManager.Auth;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.door.Common.DataTransferObject.Message;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.DataTransferObject.RESTful;
import com.sound.door.Common.Function.ReturnFunction;
import com.sound.door.Mapper.mesManager.Auth.MesAuthMapper;
import com.sound.door.mesManager.Auth.DTO.SYSAuth;

@Service
public class MesAuthService extends ReturnFunction {
	@Autowired
	private MesAuthMapper authMapper;

	public RESTful sysAuthGet(HttpServletRequest req, Page p) {
		List<SYSAuth> rows = authMapper.sysAuthGet(p);
        return getListData(rows , p);
	}

	public SYSAuth sysAuthOneGet(HttpServletRequest req, Page p) {
		return authMapper.sysAuthOneGet(p);
	}

	public Message sysAuthAU(HttpServletRequest req, SYSAuth sysAuth) {
		sysAuth.setUser_code(getSessionData(req).getUser_code());
     
        return authMapper.sysAuthAU(sysAuth);
	}

	public Message sysAuthDelete(Page p, HttpServletRequest req) {
	 
		  return authMapper.sysAuthDelete(p);
	}

}

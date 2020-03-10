package com.sound.door.Common.Various;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.Function.ReturnFunction;
import com.sound.door.Mapper.Common.Various.VariousMapper;
import com.sound.door.mesManager.Auth.DTO.SYSAuthProgram;

@Service
public class VariousService extends ReturnFunction {
	@Autowired
	private VariousMapper mapper;

	public SYSAuthProgram menuAuthGet(HttpServletRequest req, Page p) {
        p.setUser_code(getSessionData(req).getUser_code());
        return mapper.menuAuthGet(p);
	}
}

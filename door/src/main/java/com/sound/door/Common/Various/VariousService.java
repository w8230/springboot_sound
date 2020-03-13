package com.sound.door.Common.Various;

import javax.servlet.http.HttpServletRequest;

import com.sound.door.mesManager.Master.DTO.SYS_COMMON_CD;
import com.sound.door.mesManager.User.DTO.SYS_DEPT_CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.Function.ReturnFunction;
import com.sound.door.Mapper.Common.Various.VariousMapper;
import com.sound.door.mesManager.Auth.DTO.SYSAuthProgram;

import java.util.List;

@Service
public class VariousService extends ReturnFunction {
	@Autowired
	private VariousMapper mapper;

	public SYSAuthProgram menuAuthGet(HttpServletRequest req, Page p) {
        p.setUser_code(getSessionData(req).getUser_code());
        return mapper.menuAuthGet(p);
	}

    public List<SYS_DEPT_CD> sysDeptAllGet(HttpServletRequest req, Page p) {
        return mapper.sysDeptAllGet(p);
    }

    public List<SYS_COMMON_CD> sysCommonAllGet(HttpServletRequest req, Page p) {
        return mapper.sysCommonAllGet(p);
    }
}

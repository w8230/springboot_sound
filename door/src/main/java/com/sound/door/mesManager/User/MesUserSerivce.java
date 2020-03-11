package com.sound.door.mesManager.User;

import com.sound.door.Common.DataTransferObject.Message;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.DataTransferObject.RESTful;
import com.sound.door.Common.Function.ReturnFunction;
import com.sound.door.Mapper.mesManager.User.MesUserMapper;
import com.sound.door.mesManager.User.DTO.SYS_DEPT_CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MesUserSerivce  extends ReturnFunction {
    @Autowired
    private MesUserMapper mesUserMapper;

    public RESTful sysDeptGet(Page p, HttpServletRequest req) {
        List<SYS_DEPT_CD> rows = mesUserMapper.sysDeptGet(p);
        return getListData(rows , p);
    }

    public Message sysDeptAdd(SYS_DEPT_CD sdc, HttpServletRequest req) {
        sdc.setUser_code(getSessionData(req).getUser_code());
        return mesUserMapper.sysDeptAdd(sdc);
    }

    public SYS_DEPT_CD sysDeptOneGet(Page p, HttpServletRequest req) {
        return mesUserMapper.sysDeptOneGet(p);
    }

    public Message sysDeptDelete(Page p, HttpServletRequest req) {
        return mesUserMapper.sysDeptDelete(p);
    }
}

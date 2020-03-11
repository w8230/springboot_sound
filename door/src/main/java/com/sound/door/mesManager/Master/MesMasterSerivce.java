package com.sound.door.mesManager.Master;

import com.sound.door.Common.DataTransferObject.Message;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.DataTransferObject.RESTful;
import com.sound.door.Common.Function.ReturnFunction;
import com.sound.door.Mapper.mesManager.Master.MesMasterMapper;
import com.sound.door.mesManager.Master.DTO.SYS_BOARD_CD;
import com.sound.door.mesManager.Master.DTO.SYS_MSG_CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MesMasterSerivce extends ReturnFunction {

    @Autowired
    private MesMasterMapper mesMasterMapper;


    //메세지관리
    //메세지관리 메세지 목록
    public RESTful sysMsgGet(Page p) {
        List<SYS_MSG_CD> rows = mesMasterMapper.sysMsgGet(p);
        return getListData(rows , p);
    }

    //메세지관리 메세지 추가
    public Message sysMsgAdd(HttpServletRequest req, SYS_MSG_CD smc) {
        smc.setUser_code(getSessionData(req).getUser_code());
        return mesMasterMapper.sysMsgAdd(smc);
    }

    //메세지관리 메세지 수정 시 그리드에서 하나의 항목 값 조회
    public SYS_MSG_CD sysMsgOneGet(Page p) {
        return mesMasterMapper.sysMsgOneGet(p);
    }

    //메세지관리 메세지 삭제
    public Message sysMsgDelete(Page p){
        p.setKeyword(p.getKeyword());
        return mesMasterMapper.sysMsgDelete(p);
    }


    public RESTful sysBoardGet(Page p, HttpServletRequest req) {
        List<SYS_BOARD_CD> rows = mesMasterMapper.sysBoardGet(p);
        return getListData(rows , p);
    }


}

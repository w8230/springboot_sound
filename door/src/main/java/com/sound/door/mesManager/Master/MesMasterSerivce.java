package com.sound.door.mesManager.Master;

import com.sound.door.Common.DataTransferObject.Message;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.DataTransferObject.RESTful;
import com.sound.door.Common.Function.ReturnFunction;
import com.sound.door.Mapper.mesManager.Master.MesMasterMapper;
import com.sound.door.mesManager.Master.DTO.SYS_BOARD_CD;
import com.sound.door.mesManager.Master.DTO.SYS_CARGO_CD;
import com.sound.door.mesManager.Master.DTO.SYS_LINE_CD;
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


    public Message sysBoardAdd(HttpServletRequest req, SYS_BOARD_CD sbc) {
        sbc.setUser_code(getSessionData(req).getUser_code());
        return mesMasterMapper.sysBoardAdd(sbc);
    }

    public SYS_BOARD_CD sysBoardOneGet(HttpServletRequest req, Page p) {
        return mesMasterMapper.sysBoardOneGet(p);
    }

    public Message sysBoardDelete(Page p, HttpServletRequest req) {
        p.setKeyword(p.getKeyword());
        return mesMasterMapper.sysBoardDelete(p);
    }








    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public RESTful sysCargoGet(Page p, HttpServletRequest req) {
        List<SYS_CARGO_CD> rows = mesMasterMapper.sysCargoGet(p);
        return getListData(rows , p);
    }

    public SYS_CARGO_CD sysCargoOneGet(Page p, HttpServletRequest req) {
        return mesMasterMapper.sysCargoOneGet(p);
    }

    public Message sysCargoAdd(HttpServletRequest req, SYS_CARGO_CD scc) {
        scc.setUser_code(getSessionData(req).getUser_code());
        return mesMasterMapper.sysCargoAdd(scc);
    }

    public Message sysCargoDelete(HttpServletRequest req, Page p) {
        return mesMasterMapper.sysCargoDelete(p);
    }

    public List<SYS_CARGO_CD> sysCargoBAllGet(HttpServletRequest req, Page p) {
        return mesMasterMapper.sysCargoBAllGet(p);
    }


    public SYS_LINE_CD sysProdLineOneGet(Page p, HttpServletRequest req) {
        return mesMasterMapper.sysProdLineOneGet(p);
    }

    public RESTful sysProdLineGet(Page p, HttpServletRequest req) {
        List<SYS_LINE_CD> rows = mesMasterMapper.sysProdLineGet(p);
        return getListData(rows , p);
    }

    public Message sysProdLineAdd(HttpServletRequest req, SYS_LINE_CD slc) {
        slc.setUser_code(getSessionData(req).getUser_code());
        return mesMasterMapper.sysProdLineAdd(slc);
    }

    public Message sysProdLineDelete(Page p, HttpServletRequest req) {
        p.setKeyword(p.getKeyword());
        return mesMasterMapper.sysProdLineDelete(p);
    }



}

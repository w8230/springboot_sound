package com.sound.door.mesManager.Master;

import com.sound.door.Common.DataTransferObject.Message;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.DataTransferObject.RESTful;
import com.sound.door.mesManager.Master.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MesMasterRestController {


    @Autowired
    private MesMasterSerivce mesMasterSerivce;

    //메세지관리
    //메세지관리 메세지 목록
    @RequestMapping(value="/sysMsgGet", method = RequestMethod.POST)
    public RESTful sysMsg(Page p){
        return mesMasterSerivce.sysMsgGet(p);
    }

    //메세지관리 메세지 추가
    @RequestMapping(value="/sysMsgAdd", method = RequestMethod.POST)
    public Message sysMsgAdd(HttpServletRequest req, SYS_MSG_CD smc){
        return mesMasterSerivce.sysMsgAdd(req, smc);
    }

    //메세지관리 메세지 수정 시 그리드에서 하나의 항목 값 조회
    @RequestMapping(value="/sysMsgOneGet", method = RequestMethod.POST)
    public SYS_MSG_CD sysMsgOneGet(Page p) { return mesMasterSerivce.sysMsgOneGet(p); }

    //메세지관리 메세지 삭제
    @RequestMapping(value="/sysMsgDelete", method = RequestMethod.POST)
    public Message sysMsgDelete(Page p){
        return mesMasterSerivce.sysMsgDelete(p);
    }


    //게시판관리
    @RequestMapping(value="/sysBoardGet", method = RequestMethod.POST)
    public RESTful sysBoardGet(Page p,HttpServletRequest req){
        return mesMasterSerivce.sysBoardGet(p,req);
    }

    @RequestMapping(value="/sysBoardAdd", method = RequestMethod.POST)
    public Message sysBoardAdd(HttpServletRequest req, SYS_BOARD_CD sbc){ return mesMasterSerivce.sysBoardAdd(req, sbc); }

    @RequestMapping(value="/sysBoardOneGet", method = RequestMethod.POST)
    public SYS_BOARD_CD sysBoardOneGet(HttpServletRequest req, Page p) { return mesMasterSerivce.sysBoardOneGet(req, p); }

    @RequestMapping(value="/sysBoardDelete", method = RequestMethod.POST)
    public Message sysBoardDelete(Page p,HttpServletRequest req){
        return mesMasterSerivce.sysBoardDelete(p,req);
    }



    //라인정보관리
    @RequestMapping(value="/sysProdLineOneGet", method = RequestMethod.POST)
    public SYS_LINE_CD sysProdLineOneGet(Page p, HttpServletRequest req){ return mesMasterSerivce.sysProdLineOneGet(p,req); }

    @RequestMapping(value="/sysProdLineGet", method = RequestMethod.POST)
    public RESTful sysProdLineGet(Page p,HttpServletRequest req){
        return mesMasterSerivce.sysProdLineGet(p,req);
    }

    @RequestMapping(value="/sysProdLineAdd", method = RequestMethod.POST)
    public Message sysProdLineAdd(HttpServletRequest req, SYS_LINE_CD slc){ return mesMasterSerivce.sysProdLineAdd(req, slc); }

    @RequestMapping(value="/sysProdLineDelete")
    public Message sysProdLineDelete(Page p,HttpServletRequest req){ return mesMasterSerivce.sysProdLineDelete(p,req); }



    //창고관리
    @RequestMapping(value="/sysCargoGet", method = RequestMethod.POST)
    public RESTful sysCargoGet(Page p,HttpServletRequest req){ return mesMasterSerivce.sysCargoGet(p,req); }

    @RequestMapping(value="/sysCargoOneGet", method = RequestMethod.POST)
    public SYS_CARGO_CD sysCargoOneGet(Page p,HttpServletRequest req){
        return mesMasterSerivce.sysCargoOneGet(p,req);
    }

    @RequestMapping(value="/sysCargoAdd", method = RequestMethod.POST)
    public Message sysCargoAdd(HttpServletRequest req, SYS_CARGO_CD scc){ return mesMasterSerivce.sysCargoAdd(req, scc); }

    @RequestMapping(value="/sysCargoDelete", method = RequestMethod.POST)
    public Message sysCargoDelete(HttpServletRequest req,Page p){
        return mesMasterSerivce.sysCargoDelete(req,p);
    }

    @RequestMapping(value="/sysCargoBAllGet", method = RequestMethod.POST)
    public List<SYS_CARGO_CD> sysCargoBAllGet(HttpServletRequest req, Page p){ return mesMasterSerivce.sysCargoBAllGet(req,p); }



    //공통관리
    @RequestMapping(value="/sysCommonGroupAllGet", method = RequestMethod.POST)
    public List<SYS_COMMON_CD> sysCommonGroupAllGet(){ return mesMasterSerivce.sysCommonGroupAllGet(); }

    @RequestMapping(value="/sysCommonGet", method = RequestMethod.POST)
    public RESTful sysCommonGet(HttpServletRequest req, Page p){ return mesMasterSerivce.sysCommonGet(req, p); }

    @RequestMapping(value="/sysCommonOneGet", method = RequestMethod.POST)
    public SYS_COMMON_CD sysCommonOneGet(HttpServletRequest req, Page p){ return mesMasterSerivce.sysCommonOneGet(req, p); }


    @RequestMapping(value="/sysCommonAdd", method = RequestMethod.POST)
    public Message sysCommonAdd(HttpServletRequest req, SYS_COMMON_CD scc) {
        return mesMasterSerivce.sysCommonAdd(req, scc);
    }

    @RequestMapping(value="/sysCommonDelete", method = RequestMethod.POST)
    public Message sysCommonDelete(HttpServletRequest req, Page p){
        return mesMasterSerivce.sysCommonDelete(req,p);
    }


}






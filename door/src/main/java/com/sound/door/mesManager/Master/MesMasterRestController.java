package com.sound.door.mesManager.Master;

import com.sound.door.Common.DataTransferObject.Message;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.DataTransferObject.RESTful;
import com.sound.door.mesManager.Master.DTO.SYS_MSG_CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    //게시판간리 게시판 목록
    @RequestMapping(value="/sysBoardGet", method = RequestMethod.POST)
    public RESTful sysBoardGet(Page p,HttpServletRequest req){
        return mesMasterSerivce.sysBoardGet(p,req);
    }

}

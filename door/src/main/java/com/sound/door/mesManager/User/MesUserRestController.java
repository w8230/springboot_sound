package com.sound.door.mesManager.User;

        import com.sound.door.Common.DataTransferObject.Message;
        import com.sound.door.Common.DataTransferObject.Page;
        import com.sound.door.Common.DataTransferObject.RESTful;
        import com.sound.door.mesManager.User.DTO.SYS_DEPT_CD;
        import com.sound.door.mesManager.User.DTO.SYS_USER_CD;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;
        import javax.servlet.http.HttpServletRequest;

@RestController
public class MesUserRestController {
    @Autowired
    private MesUserSerivce mesUserSerivce;

    @RequestMapping(value = "/sysDeptGet", method = RequestMethod.POST)
    public RESTful sysDeptGet(Page p, HttpServletRequest req) {
        return mesUserSerivce.sysDeptGet(p, req);
    }

    @RequestMapping(value = "/sysDeptAdd", method = RequestMethod.POST)
    public Message sysDeptAdd(SYS_DEPT_CD sdc, HttpServletRequest req) {
        return mesUserSerivce.sysDeptAdd(sdc, req);
    }

    @RequestMapping(value = "/sysDeptOneGet", method = RequestMethod.POST)
    public SYS_DEPT_CD sysDeptOneGet(Page p, HttpServletRequest req) {
        return mesUserSerivce.sysDeptOneGet(p, req);
    }

    @RequestMapping(value = "/sysDeptDelete", method = RequestMethod.POST)
    public Message sysDeptDelete(Page p, HttpServletRequest req) {
        return mesUserSerivce.sysDeptDelete(p,req);
    }

    @RequestMapping(value = "/sysUserGet", method = RequestMethod.POST)
    public RESTful sysUserGet(Page p, HttpServletRequest req) {
        return mesUserSerivce.sysUserGet(p, req);
    }

    @RequestMapping(value = "/sysUserAdd", method = RequestMethod.POST)
    public Message sysUserAdd(SYS_USER_CD suc, HttpServletRequest req) {
        return mesUserSerivce.sysUserAdd(suc,req);
    }

    @RequestMapping(value = "/sysUserOneGet", method = RequestMethod.POST)
    public SYS_USER_CD sysUserOneGet(Page p, HttpServletRequest req) {
        return mesUserSerivce.sysUserOneGet(p, req);
    }

    @RequestMapping(value = "/sysUserDelete", method = RequestMethod.POST)
    public Message sysUserDelete(Page p, HttpServletRequest req) {
        return mesUserSerivce.sysUserDelete(p,req);
    }


}

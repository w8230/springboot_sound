package com.sound.door.mesManager.User;

        import com.sound.door.Common.DataTransferObject.Message;
        import com.sound.door.Common.DataTransferObject.Page;
        import com.sound.door.Common.DataTransferObject.RESTful;
        import com.sound.door.mesManager.User.DTO.SYS_DEPT_CD;
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


}

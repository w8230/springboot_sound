package com.sound.door.mesManager.User;

        import com.sound.door.Common.DataTransferObject.Page;
        import com.sound.door.Common.DataTransferObject.RESTful;
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







}

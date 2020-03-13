package com.sound.door.mesManager.Master;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MesMasterController {

    @RequestMapping(value = "/sysMsg")
    public String sysMsg(Model model) {
        model.addAttribute("template", "content/mesManager/Master/sysMsg/sysMsg");
        return "index";
    }

    @RequestMapping(value = "/sysBoard")
    public String sysBoard(Model model) {
        model.addAttribute("template", "content/mesManager/Master/sysBoard/sysBoard");
        return "index";
    }

    @RequestMapping(value = "/sysProdLine")
    public String sysProdLine(Model model) {
        model.addAttribute("template", "content/mesManager/Master/sysProdLine/sysProdLine");
        return "index";
    }

    @RequestMapping(value = "/sysCargo")
    public String sysCargo(Model model) {
        model.addAttribute("template", "content/mesManager/Master/sysCargo/sysCargo");
        return "index";
    }


    @RequestMapping(value = "/sysCommon")
    public String sysCommon(Model model) {
        model.addAttribute("template", "content/mesManager/Master/sysCommon/sysCommon");
        return "index";
    }

    @RequestMapping(value = "/sysUser")
    public String sysUser(Model model) {
        model.addAttribute("template", "content/mesManager/User/sysUser/sysUser");
        return "index";
    }

}




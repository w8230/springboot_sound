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



}

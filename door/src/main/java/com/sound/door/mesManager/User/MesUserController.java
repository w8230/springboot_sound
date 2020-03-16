package com.sound.door.mesManager.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MesUserController {
    @RequestMapping(value = "/sysDept")
    public String sysAuthList(Model model) {
        model.addAttribute("template", "content/mesManager/User/sysDept/sysDept");
        return "index";
    }

    @RequestMapping(value = "/sysUser")
    public String sysUser(Model model) {
        model.addAttribute("template", "content/mesManager/User/sysUser/sysUser");
        return "index";
    }




}

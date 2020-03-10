package com.sound.door.mesManager.Auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MesAuthContoller {
	
	@RequestMapping(value = "/sysAuth")
    public String sysAuthList(Model model) {
		model.addAttribute("template", "content/mesManager/Auth/sysAuth/sysAuth");
        return "index";
    }

    @RequestMapping(value = "/sysAuthProgram")
    public String sysAuthProgram(Model model) {
    	model.addAttribute("template", "content/mesManager/Auth/sysAuthProgram/sysAuthProgram");
        return "index";
    }

}

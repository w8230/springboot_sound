package com.sound.door.mesManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mesManagerController {
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("template", "content/home");
		return "content/login/login";
	}
}

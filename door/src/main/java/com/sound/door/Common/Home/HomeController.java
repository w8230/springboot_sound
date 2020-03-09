package com.sound.door.Common.Home;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//ㅇㅇ
@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("template", "content/home");
		return "index";
	}
}

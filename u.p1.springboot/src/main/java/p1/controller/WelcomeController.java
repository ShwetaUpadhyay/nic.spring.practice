package p1.controller;

import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("message","welcome to spring boot");
		return "welcome";
	}
}

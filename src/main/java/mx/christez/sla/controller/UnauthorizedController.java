package mx.christez.sla.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnauthorizedController {
	@RequestMapping("/unauthorized")
	public String index(Model model) {
		return "unauthorized";
	}
}
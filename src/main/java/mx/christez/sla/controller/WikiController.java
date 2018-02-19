package mx.christez.sla.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WikiController {
	@RequestMapping("/wiki")
	public String wiki(Model model) {
		return "wiki";
	}
}
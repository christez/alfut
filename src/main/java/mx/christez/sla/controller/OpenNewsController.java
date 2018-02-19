package mx.christez.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.christez.sla.service.NewService;

@Controller
public class OpenNewsController {
	@Autowired
	private NewService newService;
	
	@RequestMapping("/open-news")
	public String openLeague(Model model) {
		model.addAttribute("news", newService.findAll());
		return "open-news";
	}
}
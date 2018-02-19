package mx.christez.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.christez.sla.entity.SupportCase;
import mx.christez.sla.service.SupportService;

@Controller
public class SupportAdminController {	
	@Autowired
	private SupportService supportService;
	
	@ModelAttribute("supportCase")
	public SupportCase constructSupportCase() {
		return new SupportCase();
	}
	
	@RequestMapping("/support-admin")
	public String support(Model model) {
		model.addAttribute("supportCases", supportService.findFirstCreated());
		return "support-admin";
	}
}
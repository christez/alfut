package mx.christez.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.Commercial;
import mx.christez.sla.service.CommercialService;

@Controller
public class CommercialAdminController {
	@Autowired
	private CommercialService commercialService;
	
	@ModelAttribute("commercial")
	public Commercial constructCommercial() {
		return new Commercial();
	}
	
	@RequestMapping("/commercial-admin")
	public String gallery(Model model) {
		model.addAttribute("commercials", commercialService.findAll());
		return "commercial-admin";
	}
	
	@RequestMapping(value = "/commercial-admin/remove/{id}")
	public String removeCommercial(@PathVariable int id, RedirectAttributes redirectAttributes) {
		Commercial commercial = commercialService.findOne(id);
		commercialService.delete(commercial);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El mensaje fue eliminado exitósamente");
		
		return "redirect:/commercial-admin.html";
	}
}
package mx.christez.sla.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.Commercial;
import mx.christez.sla.service.CommercialService;

@Controller
@RequestMapping("/commercial")
public class CommercialController {
	@Autowired
	private CommercialService commercialService;
	
	@ModelAttribute("commercial")
	public Commercial constructCommercial() {
		return new Commercial();
	}
	
	@RequestMapping
	public String commercial() {
		return "commercial";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doCommercial(@Valid @ModelAttribute("commercial") Commercial commercial, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return "commercial";
		
		commercialService.save(commercial);		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La solicitud fue enviada exitósamente, en breve serás contactado");
		
		return "redirect:/commercial.html";
	}
	
	@RequestMapping(value = "/remove/{id}")
	public String remove(@PathVariable int id, RedirectAttributes redirectAttributes) {
		Commercial commercial = commercialService.findOne(id);
		commercialService.delete(commercial);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La solicitud fue eliminada exitósamente");
		
		return "redirect:/commercial.html";
	}
}
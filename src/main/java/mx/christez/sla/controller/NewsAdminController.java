package mx.christez.sla.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.New;
import mx.christez.sla.service.NewService;

@Controller
public class NewsAdminController {
	@Autowired
	private NewService newService;
	
	@ModelAttribute("new")
	public New constructNew() {
		return new New();
	}
	
	@ModelAttribute("type")
	public List<String> getTypeOfNew() {
		List<String> types = new ArrayList<String>();
		
		types.add("Informativa");
		types.add("Advertencia");
		types.add("Importante");
		
		return types;
	}
	
	@RequestMapping("/news-admin")
	public String news(Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("user", newService.findNews(username));
		return "news-admin";
	}
	
	@RequestMapping(value = "/news-admin", method = RequestMethod.POST)
	public String addNew(Model model, @Valid @ModelAttribute("new") New news, BindingResult result, Principal principal, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return news(model, principal);
		
		String username = principal.getName();
		newService.save(news, username);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La noticia fue creada exitósamente");
		
		return "redirect:/news-admin.html";
	}
	
	@RequestMapping(value = "/news-admin/remove/{id}")
	public String removeLeague(@PathVariable int id, RedirectAttributes redirectAttributes) {
		New news = newService.findOne(id);
		newService.delete(news);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La noticia fue eliminada exitósamente");
		
		return "redirect:/news-admin.html";
	}
}
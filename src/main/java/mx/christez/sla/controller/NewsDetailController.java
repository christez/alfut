package mx.christez.sla.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.New;
import mx.christez.sla.service.NewService;

@Controller
public class NewsDetailController {
	@Autowired
	private NewService newService;
	
	@ModelAttribute("new")
	public New constructNew() {
		return new New();
	}
	
	@ModelAttribute("type")
	public List<String> getTypeOfNew() {
		List<String> types = new ArrayList<String>();
		
		types.add("Informativo");
		types.add("Importante");
		types.add("Crítica");
		
		return types;
	}
	
	@RequestMapping("/news-detail")
	public String news(Model model, @RequestParam(required = false, value = "rpNewId") String rpNewId, HttpSession session, RedirectAttributes redirectAttributes, @ModelAttribute("new") New news) {
		int newId = 0;
		
		if(rpNewId == null) {
			newId = getNewId(session);
		}else {
			session.setAttribute("newId", rpNewId);
			newId = Integer.parseInt(rpNewId);
		}
		
		if(newId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe noticia asignada a ese id");
			return "redirect:/news-admin.html";
		}else {
			New newAux = newService.findOne(newId);
			news.setHeader(newAux.getHeader());
			news.setInformation(newAux.getInformation());
			news.setType(newAux.getType());
			
			model.addAttribute("newHeader", newAux.getHeader());
			return "news-detail";
		}
	}
	
	@RequestMapping(value = "/news-detail", method = RequestMethod.POST)
	public String updateNew(Model model, @Valid @ModelAttribute("new") New news, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int newId = getNewId(session);
		
		if(result.hasErrors())
			return news(model, String.valueOf(newId), session, redirectAttributes, news);
		
		if(newId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe noticia asignada a ese id");
			return "redirect:/news-admin.html";
		}else {
			newService.update(newId, news);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Noticia actualizada exitosamente");
			return "redirect:/news-detail.html";
		}
	}
	
	private int getNewId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("newId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
}
package mx.christez.sla.controller;

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

import mx.christez.sla.entity.WorldNew;
import mx.christez.sla.service.WorldNewService;

@Controller
public class WorldNewsController {
	@Autowired
	private WorldNewService worldNewService;
	
	@ModelAttribute("worldNew")
	public WorldNew constructNew() {
		return new WorldNew();
	}
	
	@RequestMapping("/world-news")
	public String news(Model model) {
		model.addAttribute("news", worldNewService.findNews().getContent());
		return "world-news";
	}
	
	@RequestMapping(value = "/world-news", method = RequestMethod.POST)
	public String addNew(Model model, @Valid @ModelAttribute("worldNew") WorldNew worldNew, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return news(model);
		
		worldNewService.save(worldNew);		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La noticia fue creada exitósamente");
		
		return "redirect:/world-news.html";
	}
	
	@RequestMapping(value = "/world-news/remove/{id}")
	public String removeLeague(@PathVariable int id, RedirectAttributes redirectAttributes) {
		WorldNew worldNew = worldNewService.findOne(id);
		worldNewService.delete(worldNew);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La noticia fue eliminada exitósamente");
		
		return "redirect:/world-news.html";
	}
}
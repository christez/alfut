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

import mx.christez.sla.entity.WorldLeague;
import mx.christez.sla.service.WorldLeagueService;

@Controller
public class WorldLeagueController {
	@Autowired
	private WorldLeagueService worldLeagueService;
	
	@ModelAttribute("league")
	public WorldLeague constructLeague() {
		return new WorldLeague();
	}
	
	@RequestMapping("/world-league")
	public String worldLeague(Model model) {
		model.addAttribute("leagues", worldLeagueService.findAll());
		return "world-league";
	}
	
	@RequestMapping(value = "/world-league", method = RequestMethod.POST)
	public String addWorldLeague(Model model, @Valid @ModelAttribute("league") WorldLeague league, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return worldLeague(model);
		
		worldLeagueService.save(league);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La liga fue creada exitósamente");
		
		return "redirect:/world-league.html";
	}
	
	@RequestMapping(value = "/world-league/remove/{id}")
	public String removeLeague(@PathVariable int id, RedirectAttributes redirectAttributes) {
		WorldLeague league = worldLeagueService.findOne(id);
		worldLeagueService.delete(league);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La liga fue eliminada exitósamente");
		
		return "redirect:/world-league.html";
	}
}
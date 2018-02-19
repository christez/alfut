package mx.christez.sla.controller;

import java.security.Principal;

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

import mx.christez.sla.entity.League;
import mx.christez.sla.service.LeagueService;

@Controller
public class LeagueAdminController {
	@Autowired
	private LeagueService leagueService;
	
	@ModelAttribute("league")
	public League constructLeague() {
		return new League();
	}
	
	@RequestMapping("/league-admin")
	public String league(Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("user", leagueService.findLeagues(username));
		return "league-admin";
	}
	
	@RequestMapping(value = "/league-admin", method = RequestMethod.POST)
	public String addLeague(Model model, @Valid @ModelAttribute("league") League league, BindingResult result, Principal principal, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return league(model, principal);
		
		String username = principal.getName();
		leagueService.save(league, username);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La liga fue creada exitósamente");
		
		return "redirect:/league-admin.html";
	}
	
	@RequestMapping(value = "/league-admin/remove/{id}")
	public String removeLeague(@PathVariable int id, RedirectAttributes redirectAttributes) {
		League league = leagueService.findOne(id);
		leagueService.delete(league);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La liga fue eliminada exitósamente");
		
		return "redirect:/league-admin.html";
	}
}
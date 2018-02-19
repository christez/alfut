package mx.christez.sla.controller;

import java.security.Principal;

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

import mx.christez.sla.entity.League;
import mx.christez.sla.service.LeagueService;

@Controller
public class LeagueDetailController {
	@Autowired
	private LeagueService leagueService;
	
	@ModelAttribute("league")
	public League constructLeague() {
		return new League();
	}
	
	@RequestMapping("/league-detail")
	public String league(Model model, @RequestParam(required = false, value = "rpLeagueId") String rpLeagueId, HttpSession session, RedirectAttributes redirectAttributes) {
		int leagueId = 0;
		
		if(rpLeagueId == null) {
			leagueId = getLeagueId(session);
		}else {
			session.setAttribute("leagueId", rpLeagueId);
			leagueId = Integer.parseInt(rpLeagueId);
		}
		
		if(leagueId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe liga con el id recibido");
			return "redirect:/league-admin.html";
		}else {
			model.addAttribute("league", leagueService.findOne(leagueId));
			return "league-detail";
		}
	}
	
	@RequestMapping(value = "/league-detail", method = RequestMethod.POST)
	public String updateLeague(Model model, @Valid @ModelAttribute("league") League league, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int leagueId = getLeagueId(session);
		
		if(result.hasErrors())
			return league(model, String.valueOf(leagueId), session, redirectAttributes);
		
		if(leagueId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe liga con el id recibido");
			return "redirect:/league-admin.html";
		}else {
			leagueService.update(leagueId, league);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Liga actualizada exitósamente");
			return "redirect:/league-detail.html";
		}
	}
	
	private int getLeagueId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("leagueId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
}
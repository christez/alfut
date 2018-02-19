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

import mx.christez.sla.entity.WorldMatch;
import mx.christez.sla.service.WorldMatchService;

@Controller
public class WorldLeagueTournamentDetailController {
	@Autowired
	private WorldMatchService worldMatchService;
	
	@ModelAttribute("match")
	public WorldMatch constructMatch() {
		return new WorldMatch();
	}
	
	@RequestMapping("/world-league-tournament-detail")
	public String match(Model model, Principal principal, @RequestParam(required = false, value = "rpMatchId") String rpMatchId, HttpSession session, RedirectAttributes redirectAttributes) {
		int matchId = 0;
		
		if(rpMatchId == null)
			matchId = getMatchId(session);
		else {
			session.setAttribute("matchId", rpMatchId);
			matchId = Integer.parseInt(rpMatchId);
		}
		
		if(matchId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay enfrentamiento asignado a esa jornada");
			return "redirect:/world-league-tournament.html";
		}else {
			model.addAttribute("match", worldMatchService.findOne(matchId));
			return "world-league-tournament-detail";
		}
	}
	
	@RequestMapping(value = "/world-league-tournament-detail", method = RequestMethod.POST)
	public String addSchedule(Model model, @Valid @ModelAttribute("match") WorldMatch match, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int matchId = getMatchId(session);
		
		if(result.hasErrors())
			return match(model, principal, String.valueOf(matchId), session, redirectAttributes);
		
		if(matchId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay enfrentamientos asignados a esa jornada");
			return "redirect:/world-league-tournament.html";
		}else {
			worldMatchService.update(matchId, match);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Enfrentamiento actualizado exitósamente");
			return "redirect:/world-league-tournament-detail.html";
		}
	}
	
	private int getMatchId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("matchId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
}
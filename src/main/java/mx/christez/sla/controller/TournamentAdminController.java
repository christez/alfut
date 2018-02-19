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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.Tournament;
import mx.christez.sla.exception.NoLeagueFoundException;
import mx.christez.sla.service.TournamentService;

@Controller
public class TournamentAdminController {
	@Autowired
	private TournamentService tournamentService;
	
	@ModelAttribute("tournament")
	public Tournament constructTournament() {
		return new Tournament();
	}
	
	@ModelAttribute("type")
	public List<String> getTypeOfTournament() {
		List<String> types = new ArrayList<String>();
		
		types.add("Por puntos");
		types.add("Por puntos más liguilla");
		types.add("Por grupos más liguilla");
		
		return types;
	}
	
	@RequestMapping("/tournament-admin")
	public String tournament(Model model, @RequestParam(required = false, value = "rpLeagueId") String rpLeagueId, HttpSession session, RedirectAttributes redirectAttributes) {
		int leagueId = 0;
		
		if(rpLeagueId == null) {
			leagueId = getLeagueId(session);
		}else {
			session.setAttribute("leagueId", rpLeagueId);
			leagueId = Integer.parseInt(rpLeagueId);
		}
		
		if(leagueId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay torneos asignados a la liga");
			return "redirect:/league-admin.html";
		}else {
			try {
				model.addAttribute("league", tournamentService.findTournaments(leagueId));
				return "tournament-admin";
			}catch(NoLeagueFoundException nlfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", nlfe.getMessage());
				return "redirect:/league-admin.html";
			}
		}
	}
	
	@RequestMapping(value = "/tournament-admin", method = RequestMethod.POST)
	public String addTournament(Model model, @Valid @ModelAttribute("tournament") Tournament tournament, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int leagueId = getLeagueId(session);
		
		if(result.hasErrors())
			return tournament(model, String.valueOf(leagueId), session, redirectAttributes);
		
		if(leagueId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay torneos asignados a la liga");
			return "redirect:/league-admin.html";
		}else {
			tournamentService.save(leagueId, tournament);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Torneo creado exitósamente");
			return "redirect:/tournament-admin.html";
		}
	}
	
	private int getLeagueId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("leagueId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
	
	@RequestMapping(value = "/tournament-admin/remove/{id}")
	public String removeTournament(@PathVariable int id, RedirectAttributes redirectAttributes, Principal principal) {
		String username = principal.getName();
		Tournament tournament = tournamentService.findOne(id);
		tournamentService.delete(username, tournament);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El torneo fue eliminado exitósamente");
		
		return "redirect:/tournament-admin.html";
	}
}
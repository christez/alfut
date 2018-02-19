package mx.christez.sla.controller;

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

import mx.christez.sla.entity.WorldTournament;
import mx.christez.sla.service.WorldLeagueService;
import mx.christez.sla.service.WorldTournamentService;

@Controller
public class WorldLeagueDetailController {
	@Autowired
	private WorldLeagueService worldLeagueService;
	
	@Autowired
	private WorldTournamentService worldTournamentService;
	
	@ModelAttribute("tournament")
	public WorldTournament constructTournament() {
		return new WorldTournament();
	}
	
	@RequestMapping("/world-league-detail")
	public String worldLeagueDetail(Model model, @RequestParam(required = false, value = "rpLeagueId") String rpLeagueId, HttpSession session, RedirectAttributes redirectAttributes) {
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
			return "redirect:/world-league.html";
		}else {
			model.addAttribute("league", worldLeagueService.findOne(leagueId));
			return "world-league-detail";
		}
	}
	
	@RequestMapping(value = "/world-league-detail", method = RequestMethod.POST)
	public String addWorldTournament(Model model, @Valid @ModelAttribute("tournament") WorldTournament tournament, BindingResult result, RedirectAttributes redirectAttributes, HttpSession session) {
		int leagueId = getLeagueId(session);
		
		if(result.hasErrors())
			return worldLeagueDetail(model, String.valueOf(leagueId), session, redirectAttributes);
		
		if(leagueId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay torneos asignados a la liga");
			return "redirect:/world-league.html";
		}else {
			worldTournamentService.save(leagueId, tournament);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Torneo creado exitósamente");
			return "redirect:/world-league-detail.html";
		}
	}
	
	private int getLeagueId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("leagueId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
	
	@RequestMapping(value = "/world-league-detail/remove/{id}")
	public String removeTournament(@PathVariable int id, RedirectAttributes redirectAttributes) {
		WorldTournament tournament = worldTournamentService.findOne(id);
		worldTournamentService.delete(tournament);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El torneo fue eliminado exitósamente");
		
		return "redirect:/world-league-detail.html";
	}
}
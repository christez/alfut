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

import mx.christez.sla.entity.WorldRanking;
import mx.christez.sla.entity.WorldTeam;
import mx.christez.sla.service.WorldRankingService;
import mx.christez.sla.service.WorldTeamService;

@Controller
public class WorldLeagueTableController {
	@Autowired
	private WorldRankingService worldRankingService;
	
	@Autowired
	private WorldTeamService worldTeamService;
	
	@ModelAttribute("ranking")
	public WorldRanking constructTournament() {
		return new WorldRanking();
	}
	
	@RequestMapping("/world-league-table")
	public String worldLeagueTable(Model model, @RequestParam(required = false, value = "rpTournamentId") String rpTournamentId, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = 0;
		
		if(rpTournamentId == null) {
			tournamentId = getTournamentId(session);
		}else {
			session.setAttribute("tournamentId", rpTournamentId);
			tournamentId = Integer.parseInt(rpTournamentId);
		}
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe torneo con el id recibido");
			return "redirect:/world-league-detail.html";
		}else {
			model.addAttribute("tournament", worldRankingService.findByTournament(tournamentId));
			return "world-league-table";
		}
	}
	
	@RequestMapping(value = "/world-league-table", method = RequestMethod.POST)
	public String addSchedule(Model model, @Valid @ModelAttribute("ranking") WorldRanking ranking, BindingResult result, RedirectAttributes redirectAttributes, HttpSession session) {
		int tournamentId = getTournamentId(session);
		
		if(result.hasErrors())
			return worldLeagueTable(model, String.valueOf(tournamentId), session, redirectAttributes);
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe torneo con el id recibido");
			return "redirect:/world-league-detail.html";
		}else {
			worldRankingService.save(tournamentId, ranking);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Tabla creada exitósamente");
			return "redirect:/world-league-table.html";
		}
	}
	
	private int getTournamentId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("tournamentId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
	
	@RequestMapping(value = "/world-league-table/remove/{id}")
	public String removeSchedule(@PathVariable int id, RedirectAttributes redirectAttributes) {
		WorldRanking ranking = worldRankingService.findOne(id);
		worldRankingService.delete(ranking);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La tabla fue eliminada exitósamente");
		
		return "redirect:/world-league-table.html";
	}
	
	@RequestMapping(value = "/world-league-table/remove/team/{id}")
	public String removeMatch(@PathVariable int id, RedirectAttributes redirectAttributes) {
		WorldTeam team = worldTeamService.findOne(id);
		worldTeamService.delete(team);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El equipo fue eliminado exitósamente");
		
		return "redirect:/world-league-table.html";
	}
}
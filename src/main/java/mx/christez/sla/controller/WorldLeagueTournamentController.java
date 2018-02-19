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

import mx.christez.sla.entity.WorldMatch;
import mx.christez.sla.entity.WorldSchedule;
import mx.christez.sla.service.WorldMatchService;
import mx.christez.sla.service.WorldScheduleService;
import mx.christez.sla.service.WorldTournamentService;

@Controller
public class WorldLeagueTournamentController {
	@Autowired
	private WorldMatchService worldMatchService;
	
	@Autowired
	private WorldScheduleService worldScheduleService;
	
	@Autowired
	private WorldTournamentService worldTournamentService;
	
	@ModelAttribute("schedule")
	public WorldSchedule constructTournament() {
		return new WorldSchedule();
	}
	
	@RequestMapping("/world-league-tournament")
	public String worldLeagueTournament(Model model, @RequestParam(required = false, value = "rpTournamentId") String rpTournamentId, HttpSession session, RedirectAttributes redirectAttributes) {
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
			model.addAttribute("tournament", worldTournamentService.findOne(tournamentId));
			return "world-league-tournament";
		}
	}
	
	@RequestMapping(value = "/world-league-tournament", method = RequestMethod.POST)
	public String addSchedule(Model model, @Valid @ModelAttribute("schedule") WorldSchedule schedule, BindingResult result, RedirectAttributes redirectAttributes, HttpSession session) {
		int tournamentId = getTournamentId(session);
		
		if(result.hasErrors())
			return worldLeagueTournament(model, String.valueOf(tournamentId), session, redirectAttributes);
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe torneo con el id recibido");
			return "redirect:/world-league-detail.html";
		}else {
			worldScheduleService.save(tournamentId, schedule);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Jornada creado exitósamente");
			return "redirect:/world-league-tournament.html";
		}
	}
	
	private int getTournamentId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("tournamentId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
	
	@RequestMapping(value = "/world-league-tournament/remove/{id}")
	public String removeSchedule(@PathVariable int id, RedirectAttributes redirectAttributes) {
		WorldSchedule schedule= worldScheduleService.findOne(id);
		worldScheduleService.delete(schedule);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La jornada fue eliminada exitósamente");
		
		return "redirect:/world-league-tournament.html";
	}
	
	@RequestMapping(value = "/world-league-tournament/remove/match/{id}")
	public String removeMatch(@PathVariable int id, RedirectAttributes redirectAttributes) {
		WorldMatch match = worldMatchService.findOne(id);
		worldMatchService.delete(match);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El enfrentamiento fue eliminado exitósamente");
		
		return "redirect:/world-league-tournament.html";
	}
}
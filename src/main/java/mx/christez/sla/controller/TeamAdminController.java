package mx.christez.sla.controller;

import java.security.Principal;

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

import mx.christez.sla.entity.Team;
import mx.christez.sla.exception.NoTournamentFoundException;
import mx.christez.sla.service.TeamService;

@Controller
public class TeamAdminController {
	@Autowired
	private TeamService teamService;
	
	@ModelAttribute("team")
	public Team constructTeam() {
		return new Team();
	}
	
	@RequestMapping("/team-admin")
	public String team(Model model, @RequestParam(required = false, value = "rpTournamentId") String rpTournamentId, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = 0;
		
		if(rpTournamentId == null) {
			tournamentId = getTournamentId(session);
		}else {
			session.setAttribute("tournamentId", rpTournamentId);
			tournamentId = Integer.parseInt(rpTournamentId);
		}
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay equipos asignados a ese torneo");
			return "redirect:/tournament-admin.html";
		}else {
			try {
				model.addAttribute("tournament", teamService.findTeams(tournamentId));
				return "team-admin";
			}catch(NoTournamentFoundException nlfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", nlfe.getMessage());
				return "redirect:/tournament-admin.html";
			}
		}
	}
	
	@RequestMapping(value = "/team-admin", method = RequestMethod.POST)
	public String addTeam(Model model, @Valid @ModelAttribute("team") Team team, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = getTournamentId(session);
		
		if(result.hasErrors())
			return team(model, String.valueOf(tournamentId), session, redirectAttributes);
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay equipos asignados a ese torneo");
			return "redirect:/tournament-admin.html";
		}else {
			teamService.save(tournamentId, team);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Equipo creado exitósamente");
			return "redirect:/team-admin.html";
		}
	}
	
	private int getTournamentId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("tournamentId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
	
	@RequestMapping(value = "/team-admin/remove/{id}")
	public String removeTeam(@PathVariable int id, RedirectAttributes redirectAttributes, Principal principal) {
		String username = principal.getName();
		Team team = teamService.findOne(id);
		teamService.delete(username, team);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El equipo fue eliminado exitósamente");
		
		return "redirect:/team-admin.html";
	}
}
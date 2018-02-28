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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.Tournament;
import mx.christez.sla.exception.NoTeamsFoundException;
import mx.christez.sla.exception.NoTournamentFoundException;
import mx.christez.sla.exception.NotEnoughClustersFoundException;
import mx.christez.sla.exception.IncorrectNumberOfClustersException;
import mx.christez.sla.exception.NotEnoughTeamsFoundException;
import mx.christez.sla.service.ScheduleService;
import mx.christez.sla.service.TournamentService;

@Controller
public class ScheduleAdminController {
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private TournamentService tournamentService;
	
	@ModelAttribute("tournament")
	public Tournament constructTournamentSchedule() {
		return new Tournament();
	}
	
	@ModelAttribute("schema")
	public List<String> getSchema() {
		List<String> schemas = new ArrayList<String>();
		
		schemas.add("Una vuelta");
		schemas.add("Dos vueltas");
		
		return schemas;
	}
	
	@ModelAttribute("numberClassified")
	public List<String> getNumberClassified() {
		List<String> numberClassified = new ArrayList<String>();
		
		numberClassified.add("2");
		numberClassified.add("4");
		numberClassified.add("8");
		numberClassified.add("16");
		numberClassified.add("32");
		
		return numberClassified;
	}
	
	@ModelAttribute("selection")
	public List<String> getSelection() {
		List<String> selections = new ArrayList<String>();
		
		selections.add("El mejor de cada grupo");
		selections.add("Los dos mejores de cada grupo");
		selections.add("Los cuatro mejores de cada grupo");
		
		return selections;
	}
	
	@RequestMapping("/schedule-admin")
	public String schedule(Model model, Principal principal, @RequestParam(required = false, value = "rpTournamentId") String rpTournamentId, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = 0;
		
		if(rpTournamentId == null) {
			tournamentId = getTournamentId(session);
		}else {
			session.setAttribute("tournamentId", rpTournamentId);
			tournamentId = Integer.parseInt(rpTournamentId);
		}
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay juegos asignados a ese torneo");
			return "redirect:/tournament-admin.html";
		}else {
			try {
				model.addAttribute("tournament", tournamentService.findOneWithSchedulesAndMatches(tournamentId));
				return "schedule-admin";
			}catch(NoTournamentFoundException ntfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", ntfe.getMessage());
				return "redirect:/tournament-admin.html";
			}
		}
	}
	
	@RequestMapping(value = "/schedule-admin", method = RequestMethod.POST, params = "points")
	public String addSchedulePoints(Model model, @Valid @ModelAttribute("tournament") Tournament tournament, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = getTournamentId(session);
		
		if(result.hasErrors())
			return schedule(model, principal, String.valueOf(tournamentId), session, redirectAttributes);
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay torneos asignados a la liga");
			return "redirect:/league-admin.html";
		}else {
			try {
				scheduleService.generateSchedulePoints(tournamentId, tournament, "points");
				
				redirectAttributes.addFlashAttribute("success", true);
				redirectAttributes.addFlashAttribute("message", "Rol de enfrentamientos creado exitósamente");
				return "redirect:/schedule-admin.html";
			}catch(NoTeamsFoundException ntfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", ntfe.getMessage());
				return "redirect:/schedule-admin.html";
			}catch(NotEnoughTeamsFoundException netfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", netfe.getMessage());
				return "redirect:/schedule-admin.html";
			}
		}
	}
	
	@RequestMapping(value = "/schedule-admin", method = RequestMethod.POST, params = "pointsPlayoffs")
	public String addSchedulePointsPlayoffs(Model model, @Valid @ModelAttribute("tournament") Tournament tournament, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = getTournamentId(session);
		
		if(result.hasErrors())
			return schedule(model, principal, String.valueOf(tournamentId), session, redirectAttributes);
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay torneos asignados a la liga");
			return "redirect:/league-admin.html";
		}else {
			try {
				scheduleService.generateSchedulePoints(tournamentId, tournament, "pointsPlayoffs");
				
				redirectAttributes.addFlashAttribute("success", true);
				redirectAttributes.addFlashAttribute("message", "Rol de enfrentamientos creado exitósamente");
				return "redirect:/schedule-admin.html";
			}catch(NoTeamsFoundException ntfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", ntfe.getMessage());
				return "redirect:/schedule-admin.html";
			}catch(NotEnoughTeamsFoundException netfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", netfe.getMessage());
				return "redirect:/schedule-admin.html";
			}
		}
	}
	
	@RequestMapping(value = "/schedule-admin", method = RequestMethod.POST, params = "groupsPlayoffs")
	public String addScheduleGroupsPlayoffs(Model model, @Valid @ModelAttribute("tournament") Tournament tournament, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = getTournamentId(session);
		
		if(result.hasErrors())
			return schedule(model, principal, String.valueOf(tournamentId), session, redirectAttributes);
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay torneos asignados a la liga");
			return "redirect:/league-admin.html";
		}else {
			try {
				scheduleService.generateScheduleGroups(tournamentId, tournament);
				
				redirectAttributes.addFlashAttribute("success", true);
				redirectAttributes.addFlashAttribute("message", "Rol de enfrentamientos creado exitósamente");
				return "redirect:/schedule-admin.html";
			}catch(NotEnoughClustersFoundException necfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", necfe.getMessage());
				return "redirect:/schedule-admin.html";
			}catch(IncorrectNumberOfClustersException ince) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", ince.getMessage());
				return "redirect:/schedule-admin.html";
			}catch(NoTeamsFoundException ntfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", ntfe.getMessage());
				return "redirect:/schedule-admin.html";
			}catch(NotEnoughTeamsFoundException netfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", netfe.getMessage());
				return "redirect:/schedule-admin.html";
			}
		}
	}
	
	@RequestMapping(value = "/schedule-admin", method = RequestMethod.POST, params = "playoffsOnly")
	public String addSchedulePlayoffs(Model model, @Valid @ModelAttribute("tournament") Tournament tournament, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = getTournamentId(session);
		
		if(result.hasErrors())
			return schedule(model, principal, String.valueOf(tournamentId), session, redirectAttributes);
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay torneos asignados a la liga");
			return "redirect:/league-admin.html";
		}else {
			try {
				scheduleService.generateSchedulePlayoffs(tournamentId, tournament);
				
				redirectAttributes.addFlashAttribute("success", true);
				redirectAttributes.addFlashAttribute("message", "Rol de enfrentamientos creado exitósamente");
				return "redirect:/schedule-admin.html";
			}catch(NoTeamsFoundException ntfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", ntfe.getMessage());
				return "redirect:/schedule-admin.html";
			}catch(NotEnoughTeamsFoundException netfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", netfe.getMessage());
				return "redirect:/schedule-admin.html";
			}
		}
	}
	
	private int getTournamentId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("tournamentId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
}
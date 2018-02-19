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

import mx.christez.sla.entity.Team;
import mx.christez.sla.service.TeamService;

@Controller
public class TeamDetailController {
	@Autowired
	private TeamService teamService;
	
	@ModelAttribute("team")
	public Team constructTeam() {
		return new Team();
	}
	
	@RequestMapping("/team-detail")
	public String team(Model model, @RequestParam(required = false, value = "rpTeamId") String rpTeamId, HttpSession session, RedirectAttributes redirectAttributes) {
		int teamId = 0;
		
		if(rpTeamId == null) {
			teamId = getTeamId(session);
		}else {
			session.setAttribute("teamId", rpTeamId);
			teamId = Integer.parseInt(rpTeamId);
		}
		
		if(teamId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe equipo con el id recibido");
			return "redirect:/team-admin.html";
		}else {
			model.addAttribute("team", teamService.findOne(teamId));
			return "team-detail";
		}
	}
	
	@RequestMapping(value = "/team-detail", method = RequestMethod.POST)
	public String updateTeam(Model model, @Valid @ModelAttribute("team") Team team, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int teamId = getTeamId(session);
		
		if(result.hasErrors())
			return team(model, String.valueOf(teamId), session, redirectAttributes);
		
		if(teamId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe equipo con el id recibido");
			return "redirect:/team-admin.html";
		}else {
			String username = principal.getName();
			teamService.update(username, teamId, team);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Equipo actualizado exitósamente");
			return "redirect:/team-detail.html";
		}
	}
	
	private int getTeamId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("teamId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
}
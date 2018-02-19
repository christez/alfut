package mx.christez.sla.controller;

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

import mx.christez.sla.entity.WorldTeam;
import mx.christez.sla.service.WorldTeamService;

@Controller
public class WorldLeagueTableDetailController {
	@Autowired
	private WorldTeamService worldTeamService;
	
	@ModelAttribute("team")
	public WorldTeam constructTeam() {
		return new WorldTeam();
	}
	
	@RequestMapping("/world-league-table-detail")
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
			return "redirect:/world-league-table.html";
		}else {
			model.addAttribute("team", worldTeamService.findOne(teamId));
			return "world-league-table-detail";
		}
	}
	
	@RequestMapping(value = "/world-league-table-detail", method = RequestMethod.POST)
	public String updateTeam(Model model, @Valid @ModelAttribute("team") WorldTeam team, BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
		int teamId = getTeamId(session);
		
		if(result.hasErrors())
			return team(model, String.valueOf(teamId), session, redirectAttributes);
		
		if(teamId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe equipo con el id recibido");
			return "redirect:/world-league-table.html";
		}else {
			worldTeamService.update(teamId, team);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Equipo actualizado exitósamente");
			return "redirect:/world-league-table-detail.html";
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
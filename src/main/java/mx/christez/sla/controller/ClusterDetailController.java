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
import mx.christez.sla.exception.NoClusterFoundException;
import mx.christez.sla.service.ClusterService;
import mx.christez.sla.service.TeamService;

@Controller
public class ClusterDetailController {
	@Autowired
	private ClusterService clusterService;
	
	@Autowired
	private TeamService teamService;
	
	@ModelAttribute("team")
	public Team constructTeam() {
		return new Team();
	}
	
	@RequestMapping("/cluster-detail")
	public String cluster(Model model, @RequestParam(required = false, value = "rpClusterId") String rpClusterId, HttpSession session, RedirectAttributes redirectAttributes) {
		int clusterId = 0;
		
		if(rpClusterId == null) {
			clusterId = getClusterId(session);
		}else {
			session.setAttribute("clusterId", rpClusterId);
			clusterId = Integer.parseInt(rpClusterId);
		}
		
		if(clusterId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No existe grupo con el id recibido");
			return "redirect:/team-admin.html";
		}else {
			try {
				model.addAttribute("cluster", clusterService.findOneWithTournamentAndTeams(clusterId));
				return "cluster-detail";
			} catch (NoClusterFoundException ncfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", ncfe.getMessage());
				return "redirect:/cluster-admin.html";
			}
		}
	}
	
	@RequestMapping(value = "/cluster-detail", method = RequestMethod.POST)
	public String addTeam(Model model, @Valid @ModelAttribute("team") Team team, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int clusterId = getClusterId(session);
		
		if(result.hasErrors())
			return cluster(model, String.valueOf(clusterId), session, redirectAttributes);
		
		if(clusterId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay grupo asignado a ese torneo");
			return "redirect:/tournament-admin.html";
		}else {
			teamService.saveWithCluster(clusterId, team);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Equipo creado exitósamente");
			return "redirect:/cluster-detail.html";
		}
	}
	
	private int getClusterId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("clusterId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
	
	@RequestMapping(value = "/cluster-detail/remove/{id}")
	public String removeTeam(@PathVariable int id, RedirectAttributes redirectAttributes, Principal principal) {
		String username = principal.getName();
		Team team = teamService.findOne(id);
		teamService.delete(username, team);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El equipo fue eliminado exitósamente");
		
		return "redirect:/cluster-detail.html";
	}
}
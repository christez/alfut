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

import mx.christez.sla.entity.Cluster;
import mx.christez.sla.exception.NoTournamentFoundException;
import mx.christez.sla.service.ClusterService;

@Controller
public class ClusterAdminController {
	@Autowired
	private ClusterService clusterService;
	
	@ModelAttribute("cluster")
	public Cluster constructGroup() {
		return new Cluster();
	}
	
	@RequestMapping("/cluster-admin")
	public String cluster(Model model, @RequestParam(required = false, value = "rpTournamentId") String rpTournamentId, HttpSession session, RedirectAttributes redirectAttributes) {
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
				model.addAttribute("tournament", clusterService.findClusters(tournamentId));
				return "cluster-admin";
			}catch(NoTournamentFoundException nlfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", nlfe.getMessage());
				return "redirect:/tournament-admin.html";
			}
		}
	}
	
	@RequestMapping(value = "/cluster-admin", method = RequestMethod.POST)
	public String addCluster(Model model, @Valid @ModelAttribute("cluster") Cluster cluster, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = getTournamentId(session);
		
		if(result.hasErrors())
			return cluster(model, String.valueOf(tournamentId), session, redirectAttributes);
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay equipos asignados a ese torneo");
			return "redirect:/tournament-admin.html";
		}else {
			clusterService.save(tournamentId, cluster);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Grupo creado exitósamente");
			return "redirect:/cluster-admin.html";
		}
	}
	
	private int getTournamentId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("tournamentId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
	
	@RequestMapping(value = "/cluster-admin/remove/{id}")
	public String removeCluster(@PathVariable int id, RedirectAttributes redirectAttributes, Principal principal) {
		String username = principal.getName();
		Cluster cluster = clusterService.findOne(id);
		clusterService.delete(username, cluster);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El grupo fue eliminado exitósamente");
		
		return "redirect:/cluster-admin.html";
	}
}
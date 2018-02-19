package mx.christez.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.service.ClusterService;
import mx.christez.sla.service.TeamService;
import mx.christez.sla.service.TournamentService;

@Controller
public class ResultTournamentController {
	@Autowired
	private ClusterService clusterService;
	
	@Autowired
	private TournamentService tournamentService;
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping("/result-tournament")
	public String openLeague(Model model, @RequestParam(required = false, value = "rpTournamentId") String rpTournamentId, RedirectAttributes redirectAttributes) {
		if(rpTournamentId == null)
			return "redirect:/index.html";
		
		try {
			int tournamentId = Integer.parseInt(rpTournamentId);
			model.addAttribute("tournamentSchedules", tournamentService.findOneWithSchedulesAndMatches(tournamentId));
			model.addAttribute("tournamentPositions", teamService.findTeams(tournamentId));
			model.addAttribute("tournamentClusters", clusterService.findClusters(tournamentId));
			return "result-tournament";
		}catch(Exception e) {
			return "redirect:/index.html";
		}
	}
}
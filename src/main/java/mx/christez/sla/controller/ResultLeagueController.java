package mx.christez.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.service.LeagueService;

@Controller
public class ResultLeagueController {
	@Autowired
	private LeagueService leagueService;
	
	@RequestMapping("/result-league")
	public String openLeague(Model model, @RequestParam(required = false, value = "rpLeagueId") String rpLeagueId, RedirectAttributes redirectAttributes) {
		if(rpLeagueId == null)
			return "redirect:/index.html";
		
		try {
			int leagueId = Integer.parseInt(rpLeagueId);
			model.addAttribute("league", leagueService.findOneWithTournaments(leagueId));
			return "result-league";
		}catch(Exception e) {
			return "redirect:/index.html";
		}
	}
}
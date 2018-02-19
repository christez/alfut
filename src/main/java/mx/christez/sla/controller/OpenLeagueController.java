package mx.christez.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.christez.sla.service.LeagueService;

@Controller
public class OpenLeagueController {
	@Autowired
	private LeagueService leagueService;
	
	@RequestMapping("/open-league")
	public String openLeague(Model model, @RequestParam(required = false, value = "rpLeagueName") String rpLeagueName) {
		String leagueName = "";
		
		if(rpLeagueName == null)
			leagueName = "A";
		else
			leagueName = rpLeagueName;
		
		model.addAttribute("leagueName", leagueName);
		model.addAttribute("leagues", leagueService.findAll(leagueName));
		return "open-league";
	}
}
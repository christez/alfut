package mx.christez.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.christez.sla.service.WorldLeagueService;

@Controller
public class OpenWorldLeagueController {
	@Autowired
	private WorldLeagueService worldLeagueService;
	
	@RequestMapping("/open-world-league")
	public String openLeague(Model model, @RequestParam(required = false, value = "rpLeagueId") String rpLeagueId) {
		model.addAttribute("leagues", worldLeagueService.findAll());
		
		if(rpLeagueId == null)
			model.addAttribute("welcomePage", true);
		else {
			model.addAttribute("welcomePage", false);
			model.addAttribute("selectedLeague", worldLeagueService.findOneWithData(Integer.parseInt(rpLeagueId)));
		}
		
		return "open-world-league";
	}
}
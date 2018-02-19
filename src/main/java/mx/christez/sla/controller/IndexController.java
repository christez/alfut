package mx.christez.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.christez.sla.service.GalleryService;
import mx.christez.sla.service.LeagueService;
import mx.christez.sla.service.TournamentService;
import mx.christez.sla.service.WorldNewService;

@Controller
public class IndexController {
	@Autowired
	private GalleryService galleryService;
	
	@Autowired
	private LeagueService leagueService;
	
	@Autowired
	private WorldNewService worldNewService;
	
	@Autowired
	private TournamentService tournamentService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("galleries", galleryService.findAll());
		model.addAttribute("leagues", leagueService.findAll());
		model.addAttribute("news", worldNewService.findAll());
		model.addAttribute("tournaments", tournamentService.findAll());
		
		return "index";
	}
}
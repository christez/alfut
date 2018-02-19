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

import mx.christez.sla.entity.Tournament;
import mx.christez.sla.service.TournamentService;

@Controller
public class TournamentDetailController {
	@Autowired
	private TournamentService tournamentService;
	
	@ModelAttribute("tournament")
	public Tournament constructTournament() {
		return new Tournament();
	}
	
	@RequestMapping("/tournament-detail")
	public String tournament(Model model, @RequestParam(required = false, value = "rpTournamentId") String rpTournamentId, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = 0;
		
		if(rpTournamentId == null) {
			tournamentId = getTournamentId(session);
		}else {
			session.setAttribute("tournamentId", rpTournamentId);
			tournamentId = Integer.parseInt(rpTournamentId);
		}
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay torneo asignado a ese id");
			return "redirect:/tournament-admin.html";
		}else {
			model.addAttribute("tournament", tournamentService.findOne(tournamentId));
			return "tournament-detail";
		}
	}
	
	@RequestMapping(value = "/tournament-detail", method = RequestMethod.POST)
	public String updateTournament(Model model, @Valid @ModelAttribute("tournament") Tournament tournament, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int tournamentId = getTournamentId(session);
		
		if(result.hasErrors())
			return tournament(model, String.valueOf(tournamentId), session, redirectAttributes);
		
		if(tournamentId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay torneo asignado a ese id");
			return "redirect:/tournament-admin.html";
		}else {
			tournamentService.update(tournamentId, tournament);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Torneo actualizado exitosamente");
			return "redirect:/tournament-detail.html";
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
package mx.christez.sla.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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

import mx.christez.sla.entity.Match;
import mx.christez.sla.exception.NoMatchFoundException;
import mx.christez.sla.service.MatchService;

@Controller
public class ScheduleDetailController {
	@Autowired
	private MatchService matchService;
	
	@ModelAttribute("match")
	public Match constructMatch() {
		return new Match();
	}
	
	@ModelAttribute("status")
	public List<String> getStatus() {
		List<String> statuses = new ArrayList<String>();
		
		statuses.add("No jugado");
		statuses.add("Jugado");
		
		return statuses;
	}
	
	@ModelAttribute("time")
	public List<String> getTime() {
		List<String> times = new ArrayList<String>();
		
		times.add("6:00 AM");
		times.add("6:30 AM");
		times.add("7:00 AM");
		times.add("7:30 AM");
		times.add("8:00 AM");
		times.add("8:30 AM");
		times.add("9:00 AM");
		times.add("9:30 AM");
		times.add("10:00 AM");
		times.add("10:30 AM");
		times.add("11:00 AM");
		times.add("11:30 AM");
		times.add("12:00 PM");
		times.add("12:30 PM");
		times.add("1:00 PM");
		times.add("1:30 PM");
		times.add("2:00 PM");
		times.add("2:30 PM");
		times.add("3:00 PM");
		times.add("3:30 PM");
		times.add("4:00 PM");
		times.add("4:30 PM");
		times.add("5:00 PM");
		times.add("5:30 PM");
		times.add("6:00 PM");
		times.add("6:30 PM");
		times.add("7:00 PM");
		times.add("7:30 PM");
		times.add("8:00 PM");
		times.add("8:30 PM");
		times.add("9:00 PM");
		times.add("9:30 PM");
		times.add("10:00 PM");
		times.add("10:30 PM");
		times.add("11:00 PM");
		times.add("11:30 PM");
		
		return times;
	}
	
	@RequestMapping("/schedule-detail")
	public String schedule(Model model, Principal principal, @RequestParam(required = false, value = "rpMatchId") String rpMatchId, @RequestParam(required = false, value = "rpScheduleNumber") String rpScheduleNumber, HttpSession session, RedirectAttributes redirectAttributes) {
		int matchId = 0;
		int scheduleNumber = 0;
		
		if(rpMatchId == null)
			matchId = getMatchId(session);
		else {
			session.setAttribute("matchId", rpMatchId);
			matchId = Integer.parseInt(rpMatchId);
		}
		
		if(matchId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay enfrentamiento asignado a esa jornada");
			return "redirect:/schedule-admin.html";
		}else {
			if(rpScheduleNumber == null)
				scheduleNumber = getScheduleNumber(session);
			else {
				session.setAttribute("scheduleNumber", rpScheduleNumber);
				scheduleNumber = Integer.parseInt(rpScheduleNumber);
			}
			
			if(scheduleNumber == 0)
				model.addAttribute("scheduleNumber", "");
			else
				model.addAttribute("scheduleNumber", scheduleNumber);
			
			try {
				model.addAttribute("match", matchService.findOne(matchId));
				return "schedule-detail";
			}catch(NoMatchFoundException nmfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", nmfe.getMessage());
				return "redirect:/schedule-admin.html";
			}
		}
	}
	
	@RequestMapping(value = "/schedule-detail", method = RequestMethod.POST)
	public String addSchedule(Model model, @Valid @ModelAttribute("match") Match match, BindingResult result, Principal principal, HttpSession session, RedirectAttributes redirectAttributes) {
		int matchId = getMatchId(session);
		int scheduleNumber = getScheduleNumber(session);
		
		if(result.hasErrors())
			return schedule(model, principal, String.valueOf(matchId), String.valueOf(scheduleNumber), session, redirectAttributes);
		
		if(matchId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay enfrentamientos asignados a esa jornada");
			return "redirect:/schedule-admin.html";
		}else {
			matchService.update(matchId, match);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Enfrentamiento actualizado exitósamente");
			return "redirect:/schedule-detail.html";
		}
	}
	
	private int getMatchId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("matchId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
	
	private int getScheduleNumber(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("scheduleNumber").toString());
		}catch(Exception e) {
			return 0;
		}
	}
}
package mx.christez.sla.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.exception.NoSecretDataFoundException;
import mx.christez.sla.exception.NoUserFoundException;
import mx.christez.sla.service.UserService;

@Controller
public class RecoverController {
	@Autowired
	private UserService userService;
	
	@ModelAttribute("questions")
	public List<String> getQuestions() {
		List<String> questions = new ArrayList<String>();
		
		questions.add("Apellido materno de tu madre");
		questions.add("Apellido materno de tu padre");
		questions.add("Lugar favorito para vacacionar");
		questions.add("Nombre de la calle donde viviste en tu infancia");
		questions.add("Nombre de tu primera mascota");
		
		return questions;
	}
	
	@ModelAttribute("user")
	public AppUser construct() {
		return new AppUser();
	}
	
	@RequestMapping("/recover")
	public String recover(Model model) {
		return "recover";
	}
	
	@RequestMapping(value = "/recover", method = RequestMethod.POST)
	public String updatePassword(Model model, @Valid @ModelAttribute("user") AppUser appUser, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return recover(model);
		
		try {
			String password = userService.recover(appUser);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", password);
		}catch(NoUserFoundException nufe) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", nufe.getMessage());
		} catch (NoSecretDataFoundException nsdfe) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", nsdfe.getMessage());
		}
		
		return "redirect:/recover.html";
	}
}
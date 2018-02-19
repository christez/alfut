package mx.christez.sla.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.AppUser;
//import mx.christez.sla.service.NotificationService;
import mx.christez.sla.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	//@Autowired
	//private NotificationService notificationService;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public AppUser construct() {
		return new AppUser();
	}
	
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
	
	@RequestMapping
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") AppUser user, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return "register";
		
		if(userService.findByUsername(user.getUsername()) == null) {
			userService.save(user);
			//notificationService.notifyActivation(user);
			
			redirectAttributes.addFlashAttribute("success", true);
			return "redirect:/register.html";
		}else {
			redirectAttributes.addFlashAttribute("invalid", true);
			return "redirect:/register.html";
		}
	}
	
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username) {
		Boolean available = userService.findByUsername(username) == null;
		return available.toString();
	}
}
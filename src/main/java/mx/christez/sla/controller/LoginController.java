package mx.christez.sla.controller;

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
import mx.christez.sla.exception.InvalidUserException;
import mx.christez.sla.service.NotificationService;

@Controller
public class LoginController {
	@Autowired
	private NotificationService notificationService;
	
	@ModelAttribute("user")
	public AppUser constructUser() {
		return new AppUser();
	}
	
	@RequestMapping("/login")
	public String index(Model model, RedirectAttributes redirectAttributes) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, params = "restore")
	public String addTeam(Model model, @Valid @ModelAttribute("user") AppUser appUser, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return index(model, redirectAttributes);
		
		try {
			notificationService.recoverPassword(appUser);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "Revisa tu cuenta de correo para restablecer tu contraseña");
			return "redirect:/login.html";
		}catch(InvalidUserException iue) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", iue.getMessage());
			return "redirect:/login.html";
		}
	}
}
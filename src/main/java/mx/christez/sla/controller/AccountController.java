package mx.christez.sla.controller;

import java.security.Principal;
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
import mx.christez.sla.security.Encrypter;
import mx.christez.sla.service.UserService;

@Controller
public class AccountController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private Encrypter encrypter;
	
	@ModelAttribute("user")
	public AppUser constructUser() {
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
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal, @ModelAttribute("user") AppUser appUser) {
		String username = principal.getName();
		AppUser userAux = userService.findByUsername(username);
		
		appUser.setEmail(userAux.getEmail());
		appUser.setLastname(userAux.getLastname());
		appUser.setName(userAux.getName());
		try{appUser.setSecretAnswer(encrypter.decrypt(userAux.getSecretAnswer()));}catch(Exception e){/*Don't do anything*/}
		appUser.setSecretQuestion(userAux.getSecretQuestion());
		appUser.setUsername(username);
		
		return "account";
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String updateAccount(Model model, @Valid @ModelAttribute("user") AppUser appUser, BindingResult result, Principal principal, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return account(model, principal, appUser);
		
		String username = principal.getName();
		userService.modify(username, appUser);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "Cuenta actualizada exitósamente");
		return "redirect:/account.html";
	}
}
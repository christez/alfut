package mx.christez.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.service.UserService;

@Controller
public class RestoreController {
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public AppUser construct() {
		return new AppUser();
	}
	
	@RequestMapping("/restore")
	public String restore(@RequestParam(required = false, value = "code") String code, Model model) {
		if(code == null) {
			model.addAttribute("success", false);
			model.addAttribute("message", "Es necesario incluir el código de activación");
		}else {
			String username = userService.restorePassword(code);
			
			if(username.startsWith("An exception occured")) {
				model.addAttribute("success", false);
				model.addAttribute("message", "Ocurrió un error al activar la cuenta. Contacta al administrador");
			}else {
				String temporalPassword = userService.update(username);
				
				model.addAttribute("success", true);
				model.addAttribute("message", "Recuperación exitosa. Tu contraseña temporal es \"" + temporalPassword + "\". Te recomendamos modificarla lo más pronto posible");
			}
		}
		
		return "restore";
	}
}
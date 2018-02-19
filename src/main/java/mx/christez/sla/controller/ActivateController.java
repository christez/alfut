package mx.christez.sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.christez.sla.service.UserService;

@Controller
public class ActivateController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/activate")
	public String activate(@RequestParam(required = false, value = "code") String code, Model model) {
		if(code == null) {
			model.addAttribute("success", false);
			model.addAttribute("message", "Es necesario incluir el código de activación");
		}else 
			if(userService.activateAccount(code) == 0) {
				model.addAttribute("success", true);
			}else {
				model.addAttribute("success", false);
				model.addAttribute("message", "Ocurrió un error al activar la cuenta. Contacta al administrador");
			}
		
		
		return "activate";
	}
}
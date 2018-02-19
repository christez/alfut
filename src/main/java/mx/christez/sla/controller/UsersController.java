package mx.christez.sla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.service.UserService;

@Controller
public class UsersController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String index(Model model, @RequestParam(required = false, value = "rpPageNumber") String rpPageNumber) {
		int pageNumber = 0;
		
		if(rpPageNumber == null)
			pageNumber = 1;
		else
			pageNumber = Integer.parseInt(rpPageNumber);
		
		Page<AppUser> page = userService.findAll(pageNumber);
		List<AppUser> users = page.getContent();
		
		int current = pageNumber;
	    int begin = Math.max(1, current - 1);
	    int end = Math.min(begin + 2, page.getTotalPages());
		
	    model.addAttribute("begin", begin);
	    model.addAttribute("end", end);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("users", users);
		
		return "users";
	}
	
	@RequestMapping(value = "/users/remove/{username}")
	public String removeTournament(@PathVariable String username, RedirectAttributes redirectAttributes) {
		AppUser user = userService.findByUsername(username);
		userService.delete(user);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El usuario fue eliminado exitósamente");
		
		return "redirect:/users.html";
	}
}
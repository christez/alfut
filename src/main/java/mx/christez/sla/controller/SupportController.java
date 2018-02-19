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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.Conversation;
import mx.christez.sla.entity.SupportCase;
import mx.christez.sla.exception.NoSupportCaseFoundException;
import mx.christez.sla.service.ConversationService;
import mx.christez.sla.service.SupportService;

@Controller
public class SupportController {	
	@Autowired
	private ConversationService conversationService;
	
	@Autowired
	private SupportService supportService;
	
	@ModelAttribute("supportCase")
	public SupportCase constructSupportCase() {
		return new SupportCase();
	}
	
	@ModelAttribute("conversation")
	public Conversation constructConversation() {
		return new Conversation();
	}
	
	@ModelAttribute("type")
	public List<String> getTypeOfCase() {
		List<String> types = new ArrayList<String>();
		
		types.add("Baja");
		types.add("Media");
		types.add("Alta");
		
		return types;
	}
	
	@RequestMapping("/support")
	public String support(Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("user", supportService.findByUsername(username));
		return "support";
	}
	
	@RequestMapping(value = "/support", method = RequestMethod.POST)
	public String addSupportCase(Model model, @Valid @ModelAttribute("supportCase") SupportCase supportCase, BindingResult result, Principal principal, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return support(model, principal);
		
		String username = principal.getName();
		supportService.save(username, supportCase);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El caso fue creada exitósamente. En breve será revisado");
		
		return "redirect:/support.html";
	}
	
	@RequestMapping(value = "/support", method = RequestMethod.POST, params = "conversation")
	public String addConversation(Model model, @Valid @ModelAttribute("conversation") Conversation conversation, BindingResult result, Principal principal, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return support(model, principal);
		
		String username = principal.getName();
		conversationService.saveFromUser(username, conversation);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El mensaje fue enviado exitósamente");
		
		return "redirect:/support.html";
	}
	
	@RequestMapping(value = "/support/close/{id}")
	public String removeSupportCase(@PathVariable int id, RedirectAttributes redirectAttributes) {
		try {
			SupportCase supportCase = supportService.findOne(id);
			supportService.delete(supportCase);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "El caso fue cerrado exitósamente");			
			return "redirect:/support.html";
		}catch(NoSupportCaseFoundException nscfe) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", nscfe.getMessage());
			return "redirect:/support.html";
		}
	}
}
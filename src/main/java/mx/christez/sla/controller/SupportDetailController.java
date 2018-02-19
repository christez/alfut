package mx.christez.sla.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.christez.sla.entity.Conversation;
import mx.christez.sla.entity.SupportCase;
import mx.christez.sla.exception.NoSupportCaseFoundException;
import mx.christez.sla.service.ConversationService;
import mx.christez.sla.service.SupportService;

@Controller
public class SupportDetailController {	
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
	
	@RequestMapping("/support-detail")
	public String support(Model model, @RequestParam(required = false, value = "rpSupportCaseId") String rpSupportCaseId, HttpSession session, RedirectAttributes redirectAttributes) {
		int supportCaseId = 0;
		
		if(rpSupportCaseId == null) {
			supportCaseId = getSupportCaseId(session);
		}else {
			session.setAttribute("supportCaseId", rpSupportCaseId);
			supportCaseId = Integer.parseInt(rpSupportCaseId);
		}
		
		if(supportCaseId == 0) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", "No hay caso de soporte con ese id");
			return "redirect:/support-admin.html";
		}else {
			try {
				model.addAttribute("supportCase", supportService.findOneWithConversations(supportCaseId));
				return "support-detail";
			}catch(NoSupportCaseFoundException nscfe) {
				redirectAttributes.addFlashAttribute("redirectedError", true);
				redirectAttributes.addFlashAttribute("message", nscfe.getMessage());
				return "redirect:/support-admin.html";
			}
		}
	}
	
	@RequestMapping(value = "/support-detail", method = RequestMethod.POST, params = "conversation")
	public String addConversation(Model model, @Valid @ModelAttribute("conversation") Conversation conversation, BindingResult result, Principal principal, RedirectAttributes redirectAttributes, HttpSession session) {
		int supportCaseId = getSupportCaseId(session);
		
		if(result.hasErrors())
			return support(model, String.valueOf(supportCaseId), session, redirectAttributes);
		
		conversationService.saveFromAdministrator(supportCaseId, conversation);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "El mensaje fue enviado exitósamente");
		
		return "redirect:/support-detail.html";
	}
	
	private int getSupportCaseId(HttpSession session) {
		try {
			return Integer.parseInt(session.getAttribute("supportCaseId").toString());
		}catch(Exception e) {
			return 0;
		}
	}
	
	@RequestMapping(value = "/support-detail/close/{id}")
	public String removeSupportCase(@PathVariable int id, RedirectAttributes redirectAttributes) {
		try {
			SupportCase supportCase = supportService.findOne(id);
			supportService.delete(supportCase);
			
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", "El caso fue cerrado exitósamente");			
			return "redirect:/support-admin.html";
		}catch(NoSupportCaseFoundException nscfe) {
			redirectAttributes.addFlashAttribute("redirectedError", true);
			redirectAttributes.addFlashAttribute("message", nscfe.getMessage());
			return "redirect:/support-admin.html";
		}
	}
}
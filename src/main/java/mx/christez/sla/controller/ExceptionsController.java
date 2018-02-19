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

import mx.christez.sla.entity.ExceptionRecords;
import mx.christez.sla.service.ExceptionsService;

@Controller
public class ExceptionsController {
	@Autowired
	private ExceptionsService exceptionsService;
	
	@RequestMapping("/exceptions")
	public String openLeague(Model model, @RequestParam(required = false, value = "rpPageNumber") String rpPageNumber) {
		int pageNumber = 0;
		
		if(rpPageNumber == null)
			pageNumber = 1;
		else
			pageNumber = Integer.parseInt(rpPageNumber);
		
		Page<ExceptionRecords> page = exceptionsService.findAll(pageNumber);
		List<ExceptionRecords> exceptions = page.getContent();
		
		int current = pageNumber;
	    int begin = Math.max(1, current - 1);
	    int end = Math.min(begin + 2, page.getTotalPages());
		
	    model.addAttribute("begin", begin);
	    model.addAttribute("end", end);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("exceptions", exceptions);
		
		return "exceptions";
	}
	
	@RequestMapping(value = "/exceptions/remove/{id}")
	public String removeLeague(@PathVariable int id, RedirectAttributes redirectAttributes) {
		ExceptionRecords exceptionRecord = exceptionsService.findOne(id);
		exceptionsService.delete(exceptionRecord);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La excepción fue eliminada exitósamente");
		
		return "redirect:/exceptions.html";
	}
}
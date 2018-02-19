package mx.christez.sla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.christez.sla.entity.WorldNew;
import mx.christez.sla.service.WorldNewService;

@Controller
public class OpenWorldNewsController {
	@Autowired
	private WorldNewService worldNewService;
	
	@RequestMapping("/open-world-new")
	public String news(Model model, @RequestParam(required = false, value = "rpPageNumber") String rpPageNumber) {
		int pageNumber = 0;
		
		if(rpPageNumber == null)
			pageNumber = 1;
		else
			pageNumber = Integer.parseInt(rpPageNumber);
		
		Page<WorldNew> page = worldNewService.findAll(pageNumber);
		List<WorldNew> news = page.getContent();
		
		int current = pageNumber;
	    int begin = Math.max(1, current - 1);
	    int end = Math.min(begin + 2, page.getTotalPages());
		
	    model.addAttribute("begin", begin);
	    model.addAttribute("end", end);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("news", news);
		
		return "open-world-new";
	}
}
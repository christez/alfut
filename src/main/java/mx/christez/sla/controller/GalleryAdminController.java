package mx.christez.sla.controller;

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

import mx.christez.sla.entity.Gallery;
import mx.christez.sla.service.GalleryService;

@Controller
public class GalleryAdminController {
	@Autowired
	private GalleryService galleryService;
	
	@ModelAttribute("gallery")
	public Gallery constructGallery() {
		return new Gallery();
	}
	
	@RequestMapping("/gallery-admin")
	public String gallery(Model model) {
		model.addAttribute("galleries", galleryService.findAll());
		return "gallery-admin";
	}
	
	@RequestMapping(value = "/gallery-admin", method = RequestMethod.POST)
	public String addGallery(Model model, @Valid @ModelAttribute("gallery") Gallery gallery, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return gallery(model);
		
		galleryService.save(gallery);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La galería fue creada exitósamente");
		
		return "redirect:/gallery-admin.html";
	}
	
	@RequestMapping(value = "/gallery-admin/remove/{id}")
	public String removeGallery(@PathVariable int id, RedirectAttributes redirectAttributes) {
		Gallery gallery = galleryService.findOne(id);
		galleryService.delete(gallery);
		
		redirectAttributes.addFlashAttribute("success", true);
		redirectAttributes.addFlashAttribute("message", "La galería fue eliminada exitósamente");
		
		return "redirect:/gallery-admin.html";
	}
}
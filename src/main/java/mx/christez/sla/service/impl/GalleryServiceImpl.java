package mx.christez.sla.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.Gallery;
import mx.christez.sla.repository.GalleryRepository;
import mx.christez.sla.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService {
	@Autowired
	private GalleryRepository galleryRepository;
	
	@Override
	public void save(Gallery gallery) {
		galleryRepository.save(gallery);
	}

	@Override
	public List<Gallery> findAll() {
		return galleryRepository.findAll();
	}

	@Override
	public Gallery findOne(int id) {
		return galleryRepository.findOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Gallery gallery) {
		galleryRepository.delete(gallery);
	}
}

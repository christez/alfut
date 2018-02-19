package mx.christez.sla.service;

import java.util.List;

import mx.christez.sla.entity.Gallery;

public interface GalleryService {
	public void save(Gallery gallery);

	public List<Gallery> findAll();

	public Gallery findOne(int id);

	public void delete(Gallery gallery);
}

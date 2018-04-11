package mx.christez.sla.service;

import java.util.List;

import org.springframework.data.domain.Page;

import mx.christez.sla.entity.Commercial;

public interface CommercialService {
	public void save(Commercial commercial);

	public Page<Commercial> findAll(int page);

	public Commercial findOne(int id);
	
	public void delete(Commercial commercial);

	public List<Commercial> findAll();
}

package mx.christez.sla.service;

import org.springframework.data.domain.Page;

import mx.christez.sla.entity.WorldNew;

public interface WorldNewService {
	public void save(WorldNew worldNew);

	public Page<WorldNew> findNews();

	public void delete(WorldNew worldNew);

	public WorldNew findOne(int id);

	public Page<WorldNew> findAll(int pageNumber);
	
	public void deleteOldNews();

	public Object findAll();
}

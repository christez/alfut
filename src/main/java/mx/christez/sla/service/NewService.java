package mx.christez.sla.service;

import java.util.List;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.New;

public interface NewService {
	public void save(New news, String username);

	public AppUser findNews(String username);

	public New findOne(int id);

	public void delete(New news);

	public void update(int newId, New news);

	public List<New> findAll();
	
	public void deleteOldNews();
}

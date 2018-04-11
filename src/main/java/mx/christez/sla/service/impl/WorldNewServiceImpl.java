package mx.christez.sla.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.WorldNew;
import mx.christez.sla.repository.WorldNewRepository;
import mx.christez.sla.service.WorldNewService;

@Service
public class WorldNewServiceImpl implements WorldNewService {
	@Autowired
	private WorldNewRepository worldNewRepository;

	@Override
	public void save(WorldNew worldNew) {
		worldNew.setCreationDate(new Date());
		worldNewRepository.save(worldNew);
	}

	@Override
	public Page<WorldNew> findNews() {
		return worldNewRepository.findAll(new PageRequest(0, 20, Direction.DESC, "creationDate"));
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(WorldNew worldNew) {
		worldNewRepository.delete(worldNew);
	}

	@Override
	public WorldNew findOne(int id) {
		return worldNewRepository.findOne(id);
	}

	@Override
	public Page<WorldNew> findAll(int page) {
		return worldNewRepository.findAll(new PageRequest(page - 1, 10, Direction.DESC, "creationDate"));
	}
	
	@Override
	@Scheduled(cron = "0 */1 1-5 * * *")
	public void deleteOldNews() {
		Page<WorldNew> pages = worldNewRepository.findAll(new PageRequest(0, 100, Direction.ASC, "creationDate"));
		List<WorldNew> newList = pages.getContent();
		Date currentDate = new Date();
		
		for(WorldNew currentNew: newList) {
			long differenceInMillies = Math.abs(currentDate.getTime() - currentNew.getCreationDate().getTime());
		    long differrenceInDays = TimeUnit.DAYS.convert(differenceInMillies, TimeUnit.MILLISECONDS);
		    
		    if(differrenceInDays > 7)
		    	worldNewRepository.delete(currentNew);
		}
	}
	
	@Override
	public List<WorldNew> findAll() {
		Page<WorldNew> pages = worldNewRepository.findAll(new PageRequest(0, 6, Direction.DESC, "creationDate"));
		List<WorldNew> newList = pages.getContent();
		
		return newList;
	}
}

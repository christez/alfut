package mx.christez.sla.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.New;
import mx.christez.sla.repository.NewRepository;
import mx.christez.sla.repository.UserRepository;
import mx.christez.sla.service.NewService;

@Service
public class NewServiceImpl implements NewService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NewRepository newRepository;

	@Override
	@Transactional
	public void save(New news, String username) {
		AppUser user = userRepository.findByUsername(username);
		news.setUser(user);
		news.setCreationDate(new Date());
		newRepository.save(news);
	}

	@Override
	@Transactional
	public AppUser findNews(String username) {
		AppUser user = userRepository.findByUsername(username);
		List<New> news = newRepository.findByUser(user, new PageRequest(0, 20, Direction.DESC, "creationDate"));
		user.setNews(news);
		
		return user;
	}

	@Override
	public New findOne(int id) {
		return newRepository.findOne(id);
	}

	@Override
	@PreAuthorize("#news.user.username == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(New news) {
		newRepository.delete(news);
	}

	@Override
	@Transactional
	public void update(int newId, New news) {
		New originalNew= newRepository.findOne(newId);
		
		originalNew.setHeader(news.getHeader());
		originalNew.setInformation(news.getInformation());
		originalNew.setType(news.getType());
	}

	@Override
	public List<New> findAll() {
		Page<New> pages = newRepository.findAll(new PageRequest(0, 20, Direction.DESC, "creationDate"));
		List<New> newList = pages.getContent();
		
		return newList;
	}

	@Override
	@Scheduled(cron = "0 */1 1-5 * * *")
	public void deleteOldNews() {
		Page<New> pages = newRepository.findAll(new PageRequest(0, 100, Direction.ASC, "creationDate"));
		List<New> newList = pages.getContent();
		Date currentDate = new Date();
		
		for(New currentNew: newList) {
			long differenceInMillies = Math.abs(currentDate.getTime() - currentNew.getCreationDate().getTime());
		    long differrenceInDays = TimeUnit.DAYS.convert(differenceInMillies, TimeUnit.MILLISECONDS);
		    
		    if(differrenceInDays > 7)
		    	newRepository.delete(currentNew);
		}
	}
}

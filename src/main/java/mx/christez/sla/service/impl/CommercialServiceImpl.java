package mx.christez.sla.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.Commercial;
import mx.christez.sla.repository.CommercialRepository;
import mx.christez.sla.service.CommercialService;

@Service
public class CommercialServiceImpl implements CommercialService {
	@Autowired
	private CommercialRepository commercialRepository;

	@Override
	@Transactional
	public void save(Commercial commercial) {
		commercial.setCreationDate(new Date());
		commercialRepository.save(commercial);
	}

	@Override
	public Page<Commercial> findAll(int page) {
		return commercialRepository.findAll(new PageRequest(page - 1, 10, Direction.DESC, "creationDate"));
	}
	
	@Override
	public Commercial findOne(int id) {
		return commercialRepository.findOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Commercial commercial) {
		commercialRepository.delete(commercial);
	}

	@Override
	public List<Commercial> findAll() {
		return commercialRepository.findAll();
	}
}

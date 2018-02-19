package mx.christez.sla.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mx.christez.sla.entity.ExceptionRecords;
import mx.christez.sla.repository.ExceptionRecordsRepository;
import mx.christez.sla.service.ExceptionsService;

@Service
public class ExceptionsServiceImpl implements ExceptionsService {
	@Autowired
	private ExceptionRecordsRepository exceptionRecordsRepository;
	
	@Override
	public Page<ExceptionRecords> findAll(int page) {
		return exceptionRecordsRepository.findAll(new PageRequest(page - 1, 10, Direction.ASC, "id"));
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(ExceptionRecords exceptionRecord) {
		exceptionRecordsRepository.delete(exceptionRecord);
	}

	@Override
	public ExceptionRecords findOne(int id) {
		return exceptionRecordsRepository.findOne(id);
	}
}

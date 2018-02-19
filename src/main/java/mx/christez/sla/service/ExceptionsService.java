package mx.christez.sla.service;

import org.springframework.data.domain.Page;

import mx.christez.sla.entity.ExceptionRecords;

public interface ExceptionsService {
	public Page<ExceptionRecords> findAll(int page);

	public void delete(ExceptionRecords exceptionRecord);

	public ExceptionRecords findOne(int id);
}

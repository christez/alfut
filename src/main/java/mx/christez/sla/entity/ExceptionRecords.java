package mx.christez.sla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExceptionRecords {
	@Column(length = 1024)
	private String additional;
	
	@Column(length = 1024)
	private String details;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 1024)
	private String method;
	
	public ExceptionRecords() {}

	public ExceptionRecords(String additional, String details, String method) {
		this.additional = additional;
		this.details = details;
		this.method = method;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}

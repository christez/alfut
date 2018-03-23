package mx.christez.sla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WorldMatch {
	private String date;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "local_name")
	private String localName;
	
	private String result;
	
	@ManyToOne
	@JoinColumn(name = "schedule_id")
	private WorldSchedule schedule;
	
	@Column(name = "visitor_name")
	private String visitorName;
	
	private String time;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public WorldSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(WorldSchedule schedule) {
		this.schedule = schedule;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}

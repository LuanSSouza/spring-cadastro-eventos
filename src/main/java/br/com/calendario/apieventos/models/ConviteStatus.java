package br.com.calendario.apieventos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "conviteStatus")
public class ConviteStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="convitestatus_id_seq")
	private Integer id;
	
	private String status;
	
	public ConviteStatus() {}

	public ConviteStatus(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

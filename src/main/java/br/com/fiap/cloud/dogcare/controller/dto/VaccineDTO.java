package br.com.fiap.cloud.dogcare.controller.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data @AllArgsConstructor
public class VaccineDTO {

	private String name;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date date;
	
	public VaccineDTO() {
		
	}
	
	public VaccineDTO(String name) {
		super();
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}

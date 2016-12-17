package br.com.fiap.cloud.dogcare.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data @AllArgsConstructor
public class VaccineDTO {

	private String name;
	
	//private LocalDate date;
	
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

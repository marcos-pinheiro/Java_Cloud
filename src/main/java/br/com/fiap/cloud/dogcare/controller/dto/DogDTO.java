package br.com.fiap.cloud.dogcare.controller.dto;

import java.util.Set;
import java.util.stream.Collectors;

import br.com.fiap.cloud.dogcare.domain.Dog;
import br.com.fiap.cloud.dogcare.domain.Vaccine;
import lombok.Data;
import lombok.EqualsAndHashCode;

//@Data @EqualsAndHashCode
public class DogDTO {
	
	private int id;
	
	private String name;
	
	private String rg;
	
	private Set<VaccineDTO> vaccines;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Set<VaccineDTO> getVaccines() {
		return vaccines;
	}

	public void setVaccines(Set<VaccineDTO> vaccines) {
		this.vaccines = vaccines;
	}
	
	public Dog toDog() {
		
		final Dog dog = new Dog();
		dog.setName(this.getName());
		dog.setRg(this.getRg());
		
		if(this.getVaccines() != null) {
			dog.setVaccines(this.getVaccines()
				.stream()
				.map(d -> new Vaccine(0, d.getName(), dog /*,d.getDate()*/))
				.collect(Collectors.toList()));
		}
		
		return dog;
	}
	
	
}

package br.com.fiap.cloud.dogcare.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @Table(name = "dog")
/*@Data @EqualsAndHashCode*/
public class Dog implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String rg;
	
	@JsonManagedReference
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "dog")
	private List<Vaccine> vaccines;
	
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

	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}

	private static final long serialVersionUID = 1L;
}

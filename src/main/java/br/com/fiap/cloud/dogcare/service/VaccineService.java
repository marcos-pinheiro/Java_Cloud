package br.com.fiap.cloud.dogcare.service;

import java.util.List;
import java.util.Optional;

import br.com.fiap.cloud.dogcare.domain.Dog;
import br.com.fiap.cloud.dogcare.service.exception.DocumentConflictException;

public interface VaccineService {

	Dog register(Dog dog) throws DocumentConflictException;

	Optional<Dog> getById(int id);
	
	void delete(int id);
	
	List<Dog> listAll();
}

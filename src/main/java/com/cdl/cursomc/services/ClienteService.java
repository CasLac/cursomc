package com.cdl.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdl.cursomc.domain.Cliente;
import com.cdl.cursomc.repositories.ClienteRepository;
import com.cdl.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
	

	public List<Cliente> findAll() {
		List<Cliente> obj = repo.findAll();
		return obj;
		}

}

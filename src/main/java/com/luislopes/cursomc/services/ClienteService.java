package com.luislopes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luislopes.cursomc.domain.Cliente;
import com.luislopes.cursomc.repositories.ClienteRepository;
import com.luislopes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> cliente = repo.findById(id);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}

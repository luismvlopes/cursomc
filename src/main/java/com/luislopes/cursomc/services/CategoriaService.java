package com.luislopes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luislopes.cursomc.domain.Categoria;
import com.luislopes.cursomc.repositories.CategoriaRepository;
import com.luislopes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objecto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}

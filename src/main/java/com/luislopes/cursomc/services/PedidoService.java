package com.luislopes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luislopes.cursomc.domain.Pedido;
import com.luislopes.cursomc.repositories.PedidoRepository;
import com.luislopes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objecto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}

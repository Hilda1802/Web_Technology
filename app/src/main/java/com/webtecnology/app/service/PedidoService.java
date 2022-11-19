package com.webtecnology.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webtecnology.app.entity.Pedido;

public interface PedidoService {
    List<Pedido> findAll();
	
	Page<Pedido> FindAll(Pageable page);
	
	Pedido findById(Long id);
	
	void save (Pedido pedido);
	
	void deleteById(Long id);
}

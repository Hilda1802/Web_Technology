package com.webtecnology.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webtecnology.app.entity.DetallePedido;

public interface DetallePedidoService {
    List<DetallePedido> findAll();
	
	Page<DetallePedido> FindAll(Pageable page);
	
	DetallePedido findById(Long id);
	
	void save (DetallePedido detallePedido);
	
	void deleteById(Long id);
}

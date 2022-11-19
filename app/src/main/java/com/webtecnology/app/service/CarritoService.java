package com.webtecnology.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webtecnology.app.entity.Carrito;

public interface CarritoService {
    List<Carrito> findAll();
	
	Page<Carrito> FindAll(Pageable page);
	
	Carrito findById(Long id);
	
	void save (Carrito carrito);
	
	void deleteById(Long id);
}

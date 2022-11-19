package com.webtecnology.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webtecnology.app.entity.Producto;

public interface ProductoService {
    List<Producto> findAll();
	
	Page<Producto> FindAll(Pageable page);
	
	Producto findById(Long id);
	
	void save (Producto producto);
	
	void deleteById(Long id);
}

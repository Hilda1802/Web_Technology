package com.webtecnology.app.service;

import java.util.List;

import com.webtecnology.app.entity.Categoria;

public interface CategoriaService {
	
	List<Categoria>  findAll();
	
	Categoria findById(Long id);
	
	void save(Categoria categoria);
	
	void deleteById(Long id);
	
}
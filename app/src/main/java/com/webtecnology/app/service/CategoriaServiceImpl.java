package com.webtecnology.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtecnology.app.entity.Categoria;
import com.webtecnology.app.repository.CategoriaRepository;
@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>) categoriaRepository.findAll();
	}

	@Override
	public Categoria findById(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Categoria categoria) {
		categoriaRepository.save(categoria);	
	}

	@Override
	public void deleteById(Long id) {
		categoriaRepository.deleteById(id);
		
	}

}
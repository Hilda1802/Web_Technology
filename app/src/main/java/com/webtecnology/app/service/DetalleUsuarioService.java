package com.webtecnology.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webtecnology.app.entity.DetalleUsuario;

public interface DetalleUsuarioService {
    List<DetalleUsuario> findAll();
	
	Page<DetalleUsuario> FindAll(Pageable page);
	
	DetalleUsuario findById(Long id);
	
	void save (DetalleUsuario detalleUsuario);
	
	void deleteById(Long id);
}

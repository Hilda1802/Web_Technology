package com.webtecnology.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webtecnology.app.entity.Rol;

public interface RolService {
    List<Rol> findAll();
	
	Page<Rol> FindAll(Pageable page);
	
	Rol findById(Long id);
	
	void save (Rol rol);
	
	void deleteById(Long id);
}

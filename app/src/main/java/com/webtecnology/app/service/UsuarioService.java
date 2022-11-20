package com.webtecnology.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webtecnology.app.entity.Usuario;

public interface UsuarioService {
    List<Usuario> findAll();
	
	Page<Usuario> FindAll(Pageable page);
	
	Usuario findById(Long id);
	
	void save (Usuario usuario);
	
	void deleteById(Long id);

	Optional<Usuario> findOneByEmail(String email);
}

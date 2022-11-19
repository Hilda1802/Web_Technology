package com.webtecnology.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webtecnology.app.entity.Usuario;
import com.webtecnology.app.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
	UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Page<Usuario> FindAll(Pageable page) {
        List<Usuario> usuarios = new ArrayList<>();
		Iterable<Usuario> registros = usuarioRepository.findAll(page);
		for(Usuario u:registros) {
		usuarios.add(u);
		}
		return new PageImpl<Usuario>(usuarios);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);        
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);        
    }
    
}

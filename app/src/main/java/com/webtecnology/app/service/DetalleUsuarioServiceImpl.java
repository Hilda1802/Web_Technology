package com.webtecnology.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webtecnology.app.entity.DetalleUsuario;
import com.webtecnology.app.repository.DetalleUsuarioRepository;

@Service
public class DetalleUsuarioServiceImpl implements DetalleUsuarioService{

    @Autowired
	DetalleUsuarioRepository detalleUsuarioRepository;

    @Override
    public List<DetalleUsuario> findAll() {
        return (List<DetalleUsuario>) detalleUsuarioRepository.findAll();
    }

    @Override
    public Page<DetalleUsuario> FindAll(Pageable page) {
        List<DetalleUsuario> detallesUsuarios = new ArrayList<>();
		Iterable<DetalleUsuario> registros = detalleUsuarioRepository.findAll(page);
		for(DetalleUsuario dU:registros) {
			detallesUsuarios.add(dU);
		}
		return new PageImpl<DetalleUsuario>(detallesUsuarios);
	}

    @Override
    public DetalleUsuario findById(Long id) {
        return detalleUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DetalleUsuario detalleUsuario) {
        detalleUsuarioRepository.save(detalleUsuario);        
    }

    @Override
    public void deleteById(Long id) {
        detalleUsuarioRepository.deleteById(id);
    }
    
}

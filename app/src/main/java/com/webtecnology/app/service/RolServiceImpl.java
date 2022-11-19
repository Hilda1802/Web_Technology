package com.webtecnology.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webtecnology.app.entity.Rol;
import com.webtecnology.app.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
	RolRepository rolRepository;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rolRepository.findAll();
    }

    @Override
    public Page<Rol> FindAll(Pageable page) {
        List<Rol> roles = new ArrayList<>();
		Iterable<Rol> registros = rolRepository.findAll(page);
		for(Rol r:registros) {
			roles.add(r);
		}
		return new PageImpl<Rol>(roles);
	}

    @Override
    public Rol findById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }
    
}

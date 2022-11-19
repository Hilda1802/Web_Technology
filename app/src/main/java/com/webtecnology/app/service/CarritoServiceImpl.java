package com.webtecnology.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webtecnology.app.entity.Carrito;
import com.webtecnology.app.repository.CarritoRepository;

@Service
public class CarritoServiceImpl implements CarritoService{

    @Autowired
	CarritoRepository carritoRepository;

    @Override
    public List<Carrito> findAll() {
        return (List<Carrito>) carritoRepository.findAll();
    }

    @Override
    public Page<Carrito> FindAll(Pageable page) {
        List<Carrito> carritos = new ArrayList<>();
		Iterable<Carrito> registros = carritoRepository.findAll(page);
		for(Carrito c:registros) {
			carritos.add(c);
		}
		return new PageImpl<Carrito>(carritos);
    }

    @Override
    public Carrito findById(Long id) {
        return carritoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Carrito carrito) {
        carritoRepository.save(carrito);
    }

    @Override
    public void deleteById(Long id) {
        carritoRepository.deleteById(id);
    }
    
}

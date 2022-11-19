package com.webtecnology.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webtecnology.app.entity.Producto;
import com.webtecnology.app.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
	ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Page<Producto> FindAll(Pageable page) {
        List<Producto> productos = new ArrayList<>();
		Iterable<Producto> registros = productoRepository.findAll(page);
		for(Producto p:registros) {
			productos.add(p);
		}
		return new PageImpl<Producto>(productos);
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);        
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);        
    }
    
}

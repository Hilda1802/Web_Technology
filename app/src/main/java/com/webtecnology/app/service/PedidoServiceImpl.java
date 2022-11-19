package com.webtecnology.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webtecnology.app.entity.Pedido;
import com.webtecnology.app.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
	PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    @Override
    public Page<Pedido> FindAll(Pageable page) {
        List<Pedido> pedidos = new ArrayList<>();
		Iterable<Pedido> registros = pedidoRepository.findAll(page);
		for(Pedido p:registros) {
		pedidos.add(p);
		}
		return new PageImpl<Pedido>(pedidos);
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);   
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id); 
    }
}

package com.webtecnology.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webtecnology.app.entity.DetallePedido;
import com.webtecnology.app.repository.DetallePedidoRepository;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{

    @Autowired
	DetallePedidoRepository detallePedidoRepository;

    @Override
    public List<DetallePedido> findAll() {
        return (List<DetallePedido>) detallePedidoRepository.findAll();
    }

    @Override
    public Page<DetallePedido> FindAll(Pageable page) {
        List<DetallePedido> detallePedidos = new ArrayList<>();
		Iterable<DetallePedido> registros = detallePedidoRepository.findAll(page);
		for(DetallePedido dP:registros) {
			detallePedidos.add(dP);
		}
		return new PageImpl<DetallePedido>(detallePedidos);
    }

    @Override
    public DetallePedido findById(Long id) {
        return detallePedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DetallePedido detallePedido) {
        detallePedidoRepository.save(detallePedido); 
    }

    @Override
    public void deleteById(Long id) {
        detallePedidoRepository.deleteById(id);
    }
    
}

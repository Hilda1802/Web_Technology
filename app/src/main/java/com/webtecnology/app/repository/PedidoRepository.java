package com.webtecnology.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.webtecnology.app.entity.Pedido;

@Repository
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long>{
    
}

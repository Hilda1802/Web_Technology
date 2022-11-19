package com.webtecnology.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.webtecnology.app.entity.DetallePedido;

@Repository
public interface DetallePedidoRepository extends PagingAndSortingRepository<DetallePedido, Long>{
    
}

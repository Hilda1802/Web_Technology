package com.webtecnology.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.webtecnology.app.entity.Carrito;

@Repository
public interface CarritoRepository extends PagingAndSortingRepository<Carrito, Long>{
    
}

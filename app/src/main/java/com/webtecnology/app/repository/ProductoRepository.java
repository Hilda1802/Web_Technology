package com.webtecnology.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.webtecnology.app.entity.Producto;

@Repository
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>{
    
}

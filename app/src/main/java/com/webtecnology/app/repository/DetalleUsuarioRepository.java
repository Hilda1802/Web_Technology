package com.webtecnology.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.webtecnology.app.entity.DetalleUsuario;

@Repository
public interface DetalleUsuarioRepository extends PagingAndSortingRepository<DetalleUsuario, Long>{
    
}

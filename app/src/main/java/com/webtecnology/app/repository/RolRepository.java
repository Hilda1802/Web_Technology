package com.webtecnology.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.webtecnology.app.entity.Rol;

@Repository
public interface RolRepository extends PagingAndSortingRepository<Rol, Long> {

}


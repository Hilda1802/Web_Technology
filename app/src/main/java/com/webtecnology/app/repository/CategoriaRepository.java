package com.webtecnology.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.webtecnology.app.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
package com.webtecnology.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webtecnology.app.entity.Carrito;
import com.webtecnology.app.service.CarritoService;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {
    @Autowired
	CarritoService carritoService;
	
	@GetMapping("/listado")
	ResponseEntity<Page<Carrito>> listar(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "nombre") String order,
			@RequestParam(defaultValue = "true") boolean asc
			){
		
			Page<Carrito>	carritos = carritoService.FindAll(PageRequest.of(page, size, Sort.by(order)));
			if(!asc) {
				carritos = carritoService.FindAll(PageRequest.of(page, size, Sort.by(order).descending()));
			}
			return ResponseEntity.ok(carritos);
	}
}

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

import com.webtecnology.app.entity.Producto;
import com.webtecnology.app.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
	ProductoService productoService;

    @GetMapping("/listado")
	ResponseEntity<Page<Producto>> listar(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "nombre") String order,
			@RequestParam(defaultValue = "true") boolean asc
			){
		
			Page<Producto>	productos = productoService.FindAll(PageRequest.of(page, size, Sort.by(order)));
			if(!asc) {
				productos = productoService.FindAll(PageRequest.of(page, size, Sort.by(order).descending()));
			}
			return ResponseEntity.ok(productos);
	}
}

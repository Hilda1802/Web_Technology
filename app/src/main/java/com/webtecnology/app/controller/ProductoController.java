package com.webtecnology.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webtecnology.app.entity.Producto;
import com.webtecnology.app.exceptions.ModelNotFoundException;
import com.webtecnology.app.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
	ProductoServiceImpl productoServiceImpl;

    @GetMapping("/listado")
	ResponseEntity<Page<Producto>> listar(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "nombre") String order,
			@RequestParam(defaultValue = "true") boolean asc
			){
		
			Page<Producto>	productos = productoServiceImpl.FindAll(PageRequest.of(page, size, Sort.by(order)));
			if(!asc) {
				productos = productoServiceImpl.FindAll(PageRequest.of(page, size, Sort.by(order).descending()));
			}
			return ResponseEntity.ok(productos);
	}

	@GetMapping("/obtenerPorId/{id}")
	public ResponseEntity<Producto> obtenerPorId(@PathVariable("id") Long id){
		Producto productoDB = productoServiceImpl.findById(id);
		if(productoDB  == null) {
			throw new ModelNotFoundException("Producto no encontrado"); 
		}
		
		return ResponseEntity.ok(productoDB);
	}

	@PostMapping("/guardar")
	public ResponseEntity<Boolean> guardar(@RequestBody Producto producto){
		productoServiceImpl.save(producto);
		return ResponseEntity.ok(true);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Boolean> actualizar(@PathVariable("id") Long id, @RequestBody Producto producto){
		Producto productoDB = productoServiceImpl.findById(id);
		if(productoDB != null) {
			return ResponseEntity.ok(false);
		}
		productoServiceImpl.save(producto);
		return ResponseEntity.ok(true);
	}

	@DeleteMapping("/eliminar/{id}")
	ResponseEntity<Boolean> eliminar(@PathVariable("id") Long id){
		Producto productoDB = productoServiceImpl.findById(id);
		if(productoDB == null) {
			throw new ModelNotFoundException("Producto no encontrado");
		}
		productoServiceImpl.deleteById(id);
		return ResponseEntity.ok(true);
	}
}

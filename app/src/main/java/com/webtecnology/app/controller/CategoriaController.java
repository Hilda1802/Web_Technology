package com.webtecnology.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webtecnology.app.entity.Categoria;
import com.webtecnology.app.exceptions.ModelNotFoundException;
import com.webtecnology.app.service.CategoriaService;
//http://localhost:8080/api

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaServiceImpl;
	@PreAuthorize("hasRole('ADMIN')")
	
	@GetMapping("/listado")
	public ResponseEntity<List<Categoria>> listado(){
		return ResponseEntity.ok(categoriaServiceImpl.findAll());
	}
	@GetMapping("/obtenerPorId/{id}")
	public ResponseEntity<Categoria> obtenerPorId(@PathVariable("id") Long id){
		Categoria categoriaDB = categoriaServiceImpl.findById(id);
		if(categoriaDB  == null) {
			throw new ModelNotFoundException("Categoria no encontrada"); 
		}
		
		return ResponseEntity.ok(categoriaDB);
	}
	@PostMapping("/guardar")
	public ResponseEntity<Boolean> guardar(@RequestBody Categoria categoria){
		categoriaServiceImpl.save(categoria);
		return ResponseEntity.ok(true);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Boolean> actualizar(@PathVariable("id") Long id, @RequestBody Categoria categoria){
		Categoria categoriaDB = categoriaServiceImpl.findById(id);
		if(categoriaDB != null) {
			return ResponseEntity.ok(false);
		}
		categoriaServiceImpl.save(categoria);
		return ResponseEntity.ok(true);
	}
	
	@DeleteMapping("/eliminar/{id}")
	ResponseEntity<Boolean> eliminar(@PathVariable("id") Long id){
		Categoria categoriaDB = categoriaServiceImpl.findById(id);
		if(categoriaDB == null) {
			throw new ModelNotFoundException("Categoria no encontrada");
		}
		
		categoriaServiceImpl.deleteById(id);
		return ResponseEntity.ok(true);
	}
	

}
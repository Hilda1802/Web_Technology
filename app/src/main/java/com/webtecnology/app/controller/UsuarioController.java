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

import com.webtecnology.app.entity.Usuario;
import com.webtecnology.app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
	UsuarioService usuarioService;
    
    @GetMapping("/listado")
	ResponseEntity<Page<Usuario>> listar(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "nombre") String order,
			@RequestParam(defaultValue = "true") boolean asc
			){
		
			Page<Usuario>	usuarios = usuarioService.FindAll(PageRequest.of(page, size, Sort.by(order)));
			if(!asc) {
				usuarios = usuarioService.FindAll(PageRequest.of(page, size, Sort.by(order).descending()));
			}
			return ResponseEntity.ok(usuarios);
	}
}

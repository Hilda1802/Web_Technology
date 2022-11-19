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

import com.webtecnology.app.entity.Pedido;
import com.webtecnology.app.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
	PedidoService pedidoService;
	
	@GetMapping("/listado")
	ResponseEntity<Page<Pedido>> listar(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "nombre") String order,
			@RequestParam(defaultValue = "true") boolean asc
			){
		
			Page<Pedido>	pedidos = pedidoService.FindAll(PageRequest.of(page, size, Sort.by(order)));
			if(!asc) {
				pedidos = pedidoService.FindAll(PageRequest.of(page, size, Sort.by(order).descending()));
			}
			return ResponseEntity.ok(pedidos);
}
}
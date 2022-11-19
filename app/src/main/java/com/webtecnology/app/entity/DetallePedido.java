package com.webtecnology.app.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "producto")
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pedido")
	private Pedido pedido;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="precioVenta")
	private BigDecimal precioVenta;
}

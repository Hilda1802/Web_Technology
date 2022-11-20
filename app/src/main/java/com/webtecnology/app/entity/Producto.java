package com.webtecnology.app.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.webtecnology.app.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="nombre")
	@NotNull(message = "El nombre es requerido")
	private String nombre;
	
	@Column(name="precioVenta")
	@NotNull(message = "El precio es requerido")
	private BigDecimal precioVenta;
	
	@Column(name="stock")
	@NotNull(message = "El stock es requerido")
	private Integer stock;
	
	@Column(name="imagen")
	private String imagen;

	@Column(name="marca")
	private String marca;
	
	@Column(name="precioCompra")
	@NotNull(message = "El precio de compra es requerido")
	private BigDecimal precioCompra;
	
	@Column(name="estado")
	@Enumerated(value = EnumType.STRING)
	private Estado estado;
	
	@Column(name="fechaRegistro")
	private LocalDate fechaRegistro;

}


package com.webtecnology.app.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "producto")
	private Producto producto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario", referencedColumnName = "id")
	private Usuario usuario;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
}

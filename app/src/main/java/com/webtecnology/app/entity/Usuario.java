package com.webtecnology.app.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.webtecnology.app.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="fechaRegistro")
	private LocalDate fechaRegistro;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detalleUsuario", referencedColumnName = "codigo")
	private DetalleUsuario detalleUsuario;
	
	@Column(name="estado")
	@Enumerated(value = EnumType.STRING)
	private Estado estado;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "rol", referencedColumnName = "codigo")
	private Rol rol;
	
	@PrePersist
	public void prePersit(){
	    fechaRegistro = LocalDate.now();
	}
}

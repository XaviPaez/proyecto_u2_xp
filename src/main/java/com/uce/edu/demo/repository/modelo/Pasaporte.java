package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pasaporte")
public class Pasaporte {

	@Id
	@Column(name = "pspt_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pspt_id_seq")
	@SequenceGenerator(name = "pspt_id_seq", sequenceName = "pspt_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "pspt_numero")
	private String numero;
	@Column(name = "pspt_fecha_emision")
	private LocalDateTime fechaEmision;
	@Column(name = "pspt_fecha_caducidad")
	private LocalDateTime fechaCaducidad;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pspt_id_ciudadanop")
	private CiudadanoP ciudadanop;

	// SET Y GET

	@Override
	public String toString() {
		return "Pasaporte [id=" + id + ", numero=" + numero + ", fechaEmision=" + fechaEmision + ", fechaCaducidad="
				+ fechaCaducidad + ", ciudadanop=" + ciudadanop + "]";
	}

	public Integer getId() {
		return id;
	}

	public CiudadanoP getCiudadanop() {
		return ciudadanop;
	}

	public void setCiudadanop(CiudadanoP ciudadanop) {
		this.ciudadanop = ciudadanop;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDateTime getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

}

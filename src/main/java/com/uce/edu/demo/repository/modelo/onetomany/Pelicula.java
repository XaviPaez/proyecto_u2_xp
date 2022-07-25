package com.uce.edu.demo.repository.modelo.onetomany;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pelicula")
public class Pelicula {

	@Id
	@Column(name="peli_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "peli_id_seq")
	@SequenceGenerator(name = "peli_id_seq", sequenceName = "peli_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "peli_nombre")
	private String nombre;
	@Column(name = "peli_fecha_estreno")
	private LocalDateTime fechaEstreno;
	
	@OneToMany(mappedBy="pelicula")
	private List<Actor> actores;

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", fechaEstreno=" + fechaEstreno 
				+ "]";
	
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDateTime fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

}
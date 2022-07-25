package com.uce.edu.demo.repository.modelo.onetomany;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Actor {
	
	
	@Id
	@Column(name="actr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actr_id_seq")
	@SequenceGenerator(name = "actr_id_seq", sequenceName = "actr_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "actr_nombre")
	private String nombre;
	@Column(name = "actr_apellido")
	private String apellido;
	@Column(name = "actr_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name = "actr_id_pelicula")
	private Pelicula pelicula ;


	
	@Override
	public String toString() {
		return "Actor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", pelicula=" + pelicula + "]";
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



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public Pelicula getPelicula() {
		return pelicula;
	}



	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

}
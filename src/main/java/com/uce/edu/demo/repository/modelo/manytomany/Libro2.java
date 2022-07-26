package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro2")
public class Libro2 {

	@Id
	@Column(name = "libr2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libr2_id_seq")
	@SequenceGenerator(name = "libr2_id_seq", sequenceName = "libr2_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "libr2_titulo")
	private String titulo;
	@Column(name = "libr2_paginas")
	private Integer cantidadPaginas;
	

	@OneToMany(mappedBy = "libro2", cascade = CascadeType.ALL)
	private List<LibroAutor> libroAutor;
	

	
	@Override
	public String toString() {
		return "Libro2 [id=" + id + ", titulo=" + titulo + ", cantidadPaginas=" + cantidadPaginas  + "]";
	}

	public List<LibroAutor> getLibroAutor() {
		return libroAutor;
	}

	public void setLibroAutor(List<LibroAutor> libroAutor) {
		this.libroAutor = libroAutor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}


	
	
	

	
	
	
	
}

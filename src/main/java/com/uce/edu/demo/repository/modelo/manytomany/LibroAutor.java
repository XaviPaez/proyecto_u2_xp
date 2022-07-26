package com.uce.edu.demo.repository.modelo.manytomany;

import javax.persistence.CascadeType;
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
@Table(name = "libro_autor_2")
public class LibroAutor {

	@Id
	@Column(name = "liau2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liau2_id_seq")
	@SequenceGenerator(name = "liau2_id_seq", sequenceName = "liau2_id_seq", allocationSize = 1)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "liau2_id_libro")
	private Libro2 libro2;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "liau2_id_autor")
	private Autor2 autor2;

	@Override
	public String toString() {
		return "LibroAutor [libro2=" + libro2 + ", autor2=" + autor2 + "]";
	}

	// SET Y GET

	public Libro2 getLibro2() {
		return libro2;
	}

	public void setLibro2(Libro2 libro2) {
		this.libro2 = libro2;
	}

	public Autor2 getAutor2() {
		return autor2;
	}

	public void setAutor2(Autor2 autor2) {
		this.autor2 = autor2;
	}

}

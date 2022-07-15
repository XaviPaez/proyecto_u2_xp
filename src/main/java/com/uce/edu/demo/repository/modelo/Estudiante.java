package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name = "Estudiante.buscarPorNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = : datoNombre"),
		@NamedQuery(name = "Estudiante.buscarPorSemestre", query = "SELECT e FROM Estudiante e WHERE e.semestre = : datoSemestre"),
		@NamedQuery(name = "Estudiante.buscarPorSemestreEdadGenero", query = "SELECT e FROM Estudiante e WHERE e.semestre=: datoSemestre AND e.edad=: datoEdad AND e.genero =: datoGenero  ORDER BY e.id"),
		@NamedQuery(name = "Estudiante.buscarPorSemestreGenero", query = "SELECT e FROM Estudiante e WHERE e.semestre=: datoSemestre AND e.genero=: datoGenero  ORDER BY e.edad") })

@NamedNativeQuery(name = "Estudiante.buscarPorSemestreGeneroNamedNative", query = "SELECT * FROM estudiante WHERE estu_semestre = :datoSemestre AND estu_genero =:datoGenero ORDER BY estu_edad", resultClass = Estudiante.class)
@NamedNativeQuery(name = "Estudiante.buscarPorNombreGeneroNamedNative", query = "SELECT * FROM estudiante WHERE estu_nombre = :datoNombre AND estu_genero =:datoGenero ORDER BY estu_semestre", resultClass = Estudiante.class)

@Table(name = "estudiante")
public class Estudiante {

	@Id
	@Column(name = "estu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
	@SequenceGenerator(name = "name_generator", sequenceName = "estu_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "estu_cedula")
	private String cedula;
	@Column(name = "estu_nombre")
	private String nombre;
	@Column(name = "estu_apellido")
	private String apellido;
	@Column(name = "estu_edad")
	private String edad;
	@Column(name = "estu_semestre")
	private String semestre;
	@Column(name = "estu_genero")
	private String genero;

	// SET Y GET

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", edad=" + edad + ", semestre=" + semestre + ", genero=" + genero + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}

package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.number.money.MonetaryAmountFormatter;

@Entity
@Table(name = "ciudadanop")
public class CiudadanoP {

	@Id
	@Column(name = "ciup_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciup_id_seq")
	@SequenceGenerator(name = "ciup_id_seq", sequenceName = "ciup_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "ciup_nombre")
	private String nombre;
	@Column(name = "ciup_apellido")
	private String apellido;
	@Column(name = "ciup_cedula")
	private String cedula;
	@Column(name = "ciup_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	

	@OneToOne(mappedBy = "ciudadanop", cascade = CascadeType.ALL)
	private Pasaporte pasaporte;

	@Override
	public String toString() {
		return "CiudadanoP [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Pasaporte getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDateTime getfechaNacimiento() {
		return fechaNacimiento;
	}

	public void setfechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}

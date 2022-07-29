package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.repository.modelo.Matricula;
import com.uce.edu.demo.prueba.repository.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba.service.IMatriculaService;
import com.uce.edu.demo.prueba.service.IPropiertarioJpaService;
import com.uce.edu.demo.prueba.service.IVehiculoJpaService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2XpApplication.class);


	@Autowired
	private IPropiertarioJpaService iPropiertarioJpaService;
	@Autowired
	private IVehiculoJpaService iVehiculoJpaService;
	@Autowired
	private IMatriculaGestorService gestorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Propietario propietario=new Propietario();
		propietario.setNombre("Xavier");
		propietario.setApellido("Paez");
		propietario.setCedula("12345");
		propietario.setFechaNacimiento(LocalDateTime.now());
		//this.iPropiertarioJpaService.crear(propietario);;
		
		Vehiculo vehiculo=new Vehiculo();
		vehiculo.setMarca("Hyundai");
		vehiculo.setPlaca("PTR-1233");
		vehiculo.setPrecio(new BigDecimal(100000));
		vehiculo.setTipo("L");
		//this.iVehiculoJpaService.insertar(vehiculo);

		this.gestorService.generar("12345", "PTR-1233");
		
		
	}
}

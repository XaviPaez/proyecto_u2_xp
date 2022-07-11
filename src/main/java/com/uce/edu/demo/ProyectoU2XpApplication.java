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

import com.uce.edu.demo.prueba.repository.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba.service.IPropiertarioJpaService;
import com.uce.edu.demo.prueba.service.IVehiculoJpaService;
import com.uce.edu.demo.prueba.service.MatriculaGestorServiceImpl;
import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2XpApplication.class);
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	@Autowired
	private IEstudianteJdbcService estudianteJdbcService;
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
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
		propietario.setNombre("Norberto");
		propietario.setApellido("Araujo");
		propietario.setCedula("2007");
		propietario.setFechaNacimiento(LocalDateTime.now());
		
		this.iPropiertarioJpaService.crear(propietario);
		
		LOG.info("Se ha insertado el propietario: " + propietario);
		
	
		
		LOG.info("Se ha consultado el propietario: " + iPropiertarioJpaService.consultar("2008") );
		

		iPropiertarioJpaService.eliminar("1756");
		
		Vehiculo vehiculo=new Vehiculo();
		vehiculo.setMarca("Hyundai");
		vehiculo.setPlaca("Pss-2007");
		vehiculo.setPrecio(new BigDecimal(18800));
		vehiculo.setTipo("L");
		
		this.iVehiculoJpaService.insertar(vehiculo);
		
		LOG.info("Se ha insertado el vehiculo: " + vehiculo);
	
				
		vehiculo.setPlaca("PTA-123");
		vehiculo.setPrecio(new BigDecimal(10000));
		this.iVehiculoJpaService.actualizar(vehiculo);
		
		LOG.info("Se ha buscado eñ vehiculo: " +iVehiculoJpaService.buscar("PTA-123"));
		this.iVehiculoJpaService.eliminar("Att-112");
		
		
	//	this.gestorService.generar("1773", "Att-112");
		
	}

}

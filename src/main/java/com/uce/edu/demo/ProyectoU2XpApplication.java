package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2XpApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	@Autowired
	private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante estudiante=new Estudiante();
		estudiante.setNombre("Claudio");
		estudiante.setApellido("Bieler");
		estudiante.setEdad("25");
		estudiante.setCedula("2008");
		estudiante.setSemestre("Octavo");
		estudiante.setGenero("Masculino");
		
		this.estudianteJpaService.guardar(estudiante);
	
		LOG.info("\n");
		//1 TypedQuery
		LOG.info("TypedQuery\n");
		Estudiante estuTyped= this.estudianteJpaService.buscarPorCedulaTyped("1234");
		LOG.info("Estudiante Typed: "+ estuTyped);
		
		List<Estudiante> estuTyped1=this.estudianteJpaService.buscarPorApellidoTyped("Paez");
		for(Estudiante estu:estuTyped1) {
			LOG.info("Estudiantes typed: "+ estu );
		}
		LOG.info("\n");
		//2 NamedQuery
		LOG.info("NamedQuery\n");
		Estudiante estuNamed=this.estudianteJpaService.buscarPorNombreNamed("Xavier");
		LOG.info("Estudiante Named: "+ estuNamed);
		
		List<Estudiante> estuNamed1=this.estudianteJpaService.buscarPorSemestreNamed("Primero");
		for(Estudiante estu1:estuNamed1) {
			LOG.info("Estudiantes Named:"+ estu1);
		}
		LOG.info("\n");
		//3 TypedNamedQuery
		LOG.info("TypedNamedQuery\n");
		List<Estudiante> estuTypedNamed=this.estudianteJpaService.buscarPorSemestreEdadGeneroTypedNamed("Primero", "19", "Femenino");
		for(Estudiante e:estuTypedNamed) {
			LOG.info("Estudiantes TypedNamed:"+ e);
			
		List<Estudiante> estuTypedNamed1=this.estudianteJpaService.buscarPorSemestreGeneroTypednamed("Primero", "Femenino");
		for(Estudiante e1: estuNamed1) {
			LOG.info("Estudiantes TypedNamed: "+ e1);
		}
		
		}
		
	

		
	}

}

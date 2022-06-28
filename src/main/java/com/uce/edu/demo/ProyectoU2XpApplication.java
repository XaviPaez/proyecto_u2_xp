package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Estudiante;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {
	
	private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2XpApplication.class);
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	@Autowired
	private IEstudianteJdbcService estudianteJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Persona persona= new Persona();
		persona.setId(3);
		persona.setNombre("Xavier");
		persona.setApellido("Paez");
		//Insertar
		//this.iPersonaJdbcService.guardar(persona);
		Persona persona2=new Persona();
		persona2.setId(3);
		persona2.setNombre("Xavier");
		persona2.setApellido("Martinez");
		//Actualizar
		//this.iPersonaJdbcService.actualizar(persona2);
		
		this.iPersonaJdbcService.eliminar(3);*/
		
		
		//LOG.info(this.iPersonaJdbcService.buscarPorId(1).toString());
		
		Estudiante e1=new Estudiante(17122345, "Pedro", "Paez", 19, "Segundo");
		Estudiante e2=new Estudiante(17122354, "Xavier", "Paez", 20, "Tercero");
		Estudiante e3=new Estudiante(17122363, "Mike", "Rodriguez", 22, "Tercero");
		Estudiante e4=new Estudiante(17122372, "Sebastian", "Ortiz", 29, "Octavo");
		Estudiante estudiante1=new Estudiante(12345, "Juan", "Ignacion", 29, "Decimo");

		//Insertar
		
		
		LOG.info("Se ha insertado : "+ estudiante1 );

		//actualizar
		Estudiante e5=new Estudiante(12345, "Xavier", "Paez", 23, "Tercero");
		
		LOG.info("Se ha actualizado el estudiante: "+ e5);
		//this.estudianteJdbcService.actualizar(e5);
		
		LOG.info("Se ha buscado el estudiante: "+ e5);
		//this.estudianteJdbcService.buscarPorId(12345);
		//Eliminar
		LOG.info("Se ha eliminado el estudiante: "+ e5);
		this.estudianteJdbcService.eliminar(17122372);
		//Buscar
	//	this.estudianteJdbcService.buscarPorId(17122354);
	}

}

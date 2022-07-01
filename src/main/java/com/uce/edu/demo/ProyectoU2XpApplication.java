package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2XpApplication.class);

	@Autowired
	private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


		//Insercion
		Estudiante estudiante=new Estudiante();
		Estudiante estudiante2=new Estudiante();
		Estudiante estudiante3=new Estudiante();
		Estudiante estudiante4=new Estudiante();
		
		estudiante.setNombre("Valeria");
		estudiante.setApellido("Acosta");
		estudiante.setCedula(1);
		estudiante.setEdad(25);
		estudiante.setSemestre("Octavo");
		
		estudiante2.setNombre("Ricardo");
		estudiante2.setApellido("Nolivos");
		estudiante2.setCedula(2);
		estudiante2.setEdad(23);
		estudiante2.setSemestre("Quinto");	

		estudiante3.setNombre("Sebastian");
		estudiante3.setApellido("Carpio");
		estudiante3.setCedula(3);
		estudiante3.setEdad(24);
		estudiante3.setSemestre("Sexto");
		
		estudiante4.setNombre("Xavier");
		estudiante4.setApellido("Paez");
		estudiante4.setCedula(4);
		estudiante4.setEdad(22);
		estudiante4.setSemestre("Sexto");
				
		
		this.estudianteJpaService.guardar(estudiante);
		this.estudianteJpaService.guardar(estudiante2);
		this.estudianteJpaService.guardar(estudiante3);
		this.estudianteJpaService.guardar(estudiante4);

		LOG.info("Se ha insertado el estudiante: " + estudiante);
		LOG.info("Se ha insertado el estudiante: " + estudiante2);
		LOG.info("Se ha insertado el estudiante: " + estudiante3);
		LOG.info("Se ha insertado el estudiante: " + estudiante4);
		
		//Actualizacion
		Estudiante estudiante5=new Estudiante();
		estudiante5.setCedula(3);
		estudiante5.setApellido("Acosta");
		estudiante3.setEdad(24);
		estudiante3.setSemestre("Sexto");
		estudiante5.setApellido("Sebastian");

		this.estudianteJpaService.actualizar(estudiante5);
		
		LOG.info("Se ha actualizado el estudiante: " +estudiante5);
		
		//Busqueda
		
		this.estudianteJpaService.buscarPorId(3);
		LOG.info("Se ha buscado el estudainte: "+ estudiante3);
		//Eliminacion
		
		this.estudianteJpaService.eliminar(2);

		LOG.info("Se ha eliminado el estudainte: " + estudiante2);

	}

}

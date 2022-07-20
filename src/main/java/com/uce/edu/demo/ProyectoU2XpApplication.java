package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.EstudianteContadorSemestre;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2XpApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("Joss");
		ciu1.setApellido("Riera");
		
		Empleado empl1 = new Empleado();
		empl1.setCodigoIess("123");
		empl1.setSalario(new BigDecimal(200));
		empl1.setCiudadano(ciu1);
		
		ciu1.setEmpleado(empl1);
		this.ciudadanoService.insertar(ciu1);
		
		Ciudadano ciu2= new Ciudadano();
		ciu2.setNombre("Joss");
		ciu2.setApellido("Riera");
		
		Empleado empl2 = new Empleado();
		empl2.setCodigoIess("123");
		empl2.setSalario(new BigDecimal(200));
		empl2.setCiudadano(ciu1);
		
		ciu2.setEmpleado(empl2);
	
	}
}

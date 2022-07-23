package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.ICiudadanoPJpaService;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;
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
	@Autowired
	private ICiudadanoPJpaService ciudadanoPJpaService;
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Hotel hotel=new Hotel();
		hotel.setNombre("Hilton Colon GYE");
		hotel.setDireccion("Malecon");
		this.hotelService.insertar(hotel);
		
		Habitacion habi1 = new Habitacion();
		habi1.setNumero("A2334");
		habi1.setPiso("10");
		habi1.setTipo("Familiar");
		habi1.setHotel(hotel);
		
		Habitacion habi2 = new Habitacion();
		habi2.setNumero("1231223");
		habi2.setPiso("1");
		habi2.setTipo("Matrimonial");
		habi2.setHotel(hotel);
		
		this.habitacionService.insertar(habi1);
		this.habitacionService.insertar(habi2);
		
	}
}

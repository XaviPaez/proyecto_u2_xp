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

import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;
import com.uce.edu.demo.service.IAutor2Service;
import com.uce.edu.demo.service.ILibro2Service;
import com.uce.edu.demo.service.ILibroAutorService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2XpApplication.class);

	@Autowired
	private ILibro2Service iLibro2Service;
	@Autowired
	private IAutor2Service autor2Service;
	@Autowired
	private ILibroAutorService autorService;
	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Factura f= this.facturaService.buscar(1);
		LOG.info("Numero: "+ f.getNumero());
		LOG.info("Fecha: "+ f.getFecha());
		LOG.info("Tarjeta: "+ f.getCliente().getNumeroTarjeta());
		
		List<DetalleFactura> detalles=f.getDetalles();
		
		for(DetalleFactura deta:detalles) {
			LOG.info("Detalle: "+deta);
		}
		
	}
}

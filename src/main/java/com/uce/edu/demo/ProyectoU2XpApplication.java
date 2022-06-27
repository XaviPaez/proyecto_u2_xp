package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.tools.javac.Main;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {
	
	private static Logger logger=Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola Mundo");
		logger.debug("LOG DEBUG");
		logger.info("LOG INFO");
		logger.warn("LOG WARN");
		logger.error("LOG ERROR");
		logger.fatal("LOG FATAL");

	}

}

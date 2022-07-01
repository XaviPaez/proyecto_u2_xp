package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.EstudianteTo;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EstudianteTo buscarPorId(int cedula) {
		// TODO Auto-generated method stub
		System.out.println("Se ha buscado el estudiante : "+ cedula);
		return this.jdbcTemplate.queryForObject("select * from estudiante where cedula=?", new Object[] { cedula },
				new BeanPropertyRowMapper<EstudianteTo>(EstudianteTo.class));
	}

	@Override
	public void insertar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into estudiante (cedula, nombre, apellido, edad, semestre) values (?,?,?,?,?)",
				new Object[] { estudiante.getCedula(), estudiante.getNombre(), estudiante.getApellido(),
						estudiante.getEdad(), estudiante.getSemestre() });
	}

	@Override
	public void actualizar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update estudiante set nombre=?,apellido=? where cedula=?",
				new Object[] { estudiante.getNombre(), estudiante.getApellido(), estudiante.getCedula() });
	}

	@Override
	public void eliminar(int cedula) {
		// TODO Auto-generated method stub
		System.out.println("Se elimino el estudiante: " + cedula);
		this.jdbcTemplate.update("delete from cedula where id=?", new Object[] { cedula });
	}

}

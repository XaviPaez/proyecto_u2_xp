package com.uce.edu.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.PersonaTo;

@Repository
public class PersonaJdbcRepositoryImpl implements IPersonaJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public PersonaTo buscarPorId(int id) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("select * from persona where id=?", new Object[] { id },
				new BeanPropertyRowMapper<PersonaTo>(PersonaTo.class));
	}

	@Override
	public void insertar(PersonaTo persona) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into persona (id, nombre, apellido) values (?,?,?)",
				new Object[] { persona.getId(), persona.getNombre(), persona.getApellido() });
	}

	@Override
	public void actualizar(PersonaTo persona) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update persona set nombre=?,apellido=? where id=?",
				new Object[] { persona.getNombre(), persona.getApellido(), persona.getId() });
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		System.out.println("Se elimino el usuario: " + id);
		this.jdbcTemplate.update("delete from persona where id=?", new Object[] { id });
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query("select * from persona",new PersonaRowMapper());
		
	}

	class PersonaRowMapper implements RowMapper<PersonaTo>{

		@Override
		public PersonaTo mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			PersonaTo persona= new PersonaTo();
			persona.setId(rs.getInt("id"));
			persona.setNombre(rs.getString("Nombre"));
			persona.setApellido(rs.getString("Apellido"));
			return persona;
		}
		
	}
	
}
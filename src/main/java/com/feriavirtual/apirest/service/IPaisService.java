package com.feriavirtual.apirest.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Pais;

public interface IPaisService {
	
	Mensaje crearPais(JdbcTemplate jdbcTemplate, Pais pais);
	
	List<Pais> listarPais(JdbcTemplate jdbcTemplate);
	
	Pais getPaisById(JdbcTemplate jdbcTemplate, int id);
	
	Mensaje updatePais(JdbcTemplate jdbcTemplate, int id, Pais pais);
	
	Mensaje borrarPais(JdbcTemplate jdbcTemplate, int id);

}

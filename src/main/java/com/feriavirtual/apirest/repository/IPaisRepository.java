package com.feriavirtual.apirest.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Pais;

public interface IPaisRepository {
	
	int crearPais(String descripcion);
	
	List<Pais> listarPaises ();
	
	Pais buscarPaisPorId(int idPais);
	
	int editarPais(int id, String descripcion);
	
	int borrarPais(int id);
	
	JdbcTemplate getJdbcTemplate();
	
	void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

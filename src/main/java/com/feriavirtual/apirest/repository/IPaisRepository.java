package com.feriavirtual.apirest.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Pais;

public interface IPaisRepository {
	
	boolean crearPais(String descripcion);
	
	List<Pais> listarPaises ();
	
	Pais buscarPaisPorId(int idPais);
	
	boolean editarPais(int id, String descripcion);
	
	boolean borrarPais(int id);
	
	JdbcTemplate getJdbcTemplate();
	
	void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

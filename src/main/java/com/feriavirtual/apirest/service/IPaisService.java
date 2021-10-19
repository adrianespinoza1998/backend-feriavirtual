package com.feriavirtual.apirest.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Pais;

public interface IPaisService {
	
	Mensaje crearPais(Pais pais);
	
	List<Pais> listarPais();
	
	Pais getPaisById(int id);
	
	Mensaje updatePais(int id, Pais pais);
	
	Mensaje borrarPais(int id);

}

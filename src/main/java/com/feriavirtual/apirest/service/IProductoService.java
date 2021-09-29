package com.feriavirtual.apirest.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Productos;

public interface IProductoService {

	Mensaje crearProducto(JdbcTemplate jdbcTemplate, Productos producto);
	
	List<Productos> listarProductos(JdbcTemplate jdbcTemplate, int idRol);
	
	Productos getProductoById(JdbcTemplate jdbcTemplate, int id);
	
	Mensaje updateProducto(JdbcTemplate jdbcTemplate, Productos producto, int id);
	
	Mensaje borrarProducto(JdbcTemplate jdbcTemplate, int id);
}

package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Productos;

public interface IProductoRepository {
	
	int crearProducto(String nombreProducto, int medidaProducto, int precioProducto, int stockProducto, int idRol);
	
	List<Productos> listarProductos (int idRol);
	
	Productos buscarProductoPorId(int idProducto);
	
	int editarProducto(String nombreProducto, int medidaProducto, int precioProducto, int stockProducto, int idRol,
			int idProducto);
	
	int borrarProducto(int id);
	
	JdbcTemplate getJdbcTemplate();
	
	void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

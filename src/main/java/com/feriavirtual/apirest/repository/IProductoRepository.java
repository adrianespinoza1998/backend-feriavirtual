package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Productos;

public interface IProductoRepository {
	
	boolean crearProducto(int kilos, int precio, int stock, int idUsuario, int idTipoProducto);
	
	List<Productos> listarProductos (int idUsuario);
	
	Productos buscarProductoPorId(int idProducto);
	
	boolean editarProducto(int id, int kilos, int precio, int stock, int idUsuario, int idTipoProducto);
	
	boolean borrarProducto(int id);
	
	JdbcTemplate getJdbcTemplate();
	
	void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

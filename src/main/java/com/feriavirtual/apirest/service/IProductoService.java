package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Productos;

public interface IProductoService {

	Mensaje crearProducto(Productos producto);
	
	List<Productos> listarProductos(int idUsuario);
	
	Productos getProductoById(int id);
	
	Mensaje updateProducto(Productos producto, int id);
	
	Mensaje borrarProducto(int id);
}

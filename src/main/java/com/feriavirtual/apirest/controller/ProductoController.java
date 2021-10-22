package com.feriavirtual.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Productos;
import com.feriavirtual.apirest.service.IProductoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@PostMapping("/api/producto")
	public Mensaje crearProducto(@RequestBody Productos producto){		
		return productoService.crearProducto(producto);
	}
	
	@GetMapping("/api/producto/{id}")
	public List<Productos> listarProducto(@PathVariable int id){
		return productoService.listarProductos(id);
	}
	
	@GetMapping("/api/producto/buscar/{id}")
	public Productos getProductoById(@PathVariable int id) {
		return productoService.getProductoById(id);
	}
	
	@PutMapping("/api/producto/{id}")
	public Mensaje updateProducto(@PathVariable int id,
			@RequestBody Productos producto) {
		return productoService.updateProducto(producto, id);
	}
	
	@DeleteMapping("/api/producto/{id}")
	public Mensaje borrarProducto(@PathVariable int id) {
		return productoService.borrarProducto(id);
	}

}

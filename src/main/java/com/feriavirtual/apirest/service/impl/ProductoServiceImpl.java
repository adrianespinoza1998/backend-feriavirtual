package com.feriavirtual.apirest.service.impl;

import java.util.List;

import com.feriavirtual.apirest.models.ProductosJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Productos;
import com.feriavirtual.apirest.repository.IProductoRepository;
import com.feriavirtual.apirest.service.IProductoService;

@Configurable
@Service
@EnableAutoConfiguration
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProductoServiceImpl() {
		
	}

	@Override
	public Mensaje crearProducto(Productos producto) {
		productoRepository.setJdbcTemplate(jdbcTemplate);

		Mensaje mensaje = new Mensaje();

		try{
			boolean crearProducto = productoRepository.crearProducto(producto.getKilos(),
					producto.getPrecio(), producto.getStock(), producto.getIdUsuario(),
					producto.getIdTipoProducto(), producto.getImg());

			if(crearProducto){
				mensaje.setMsg("Producto con el id tipo producto: " + producto.getIdTipoProducto() + " creado de forma correcta");

				return mensaje;
			}

			mensaje.setMsg("No se creo el producto con el id tipo producto:  " + producto.getIdTipoProducto());

			return mensaje;
		}catch (Exception e){
			mensaje.setMsg(e.getMessage());
			e.printStackTrace();

			return mensaje;
		}
	}

	@Override
	public List<ProductosJoin> listarProductos(int idUsario) {
		productoRepository.setJdbcTemplate(jdbcTemplate);
		return productoRepository.listarProductos(idUsario);
	}

	@Override
	public Productos getProductoById(int id) {
		productoRepository.setJdbcTemplate(jdbcTemplate);
		return productoRepository.buscarProductoPorId(id);
	}

	@Override
	public Mensaje updateProducto(Productos producto, int id) {
		productoRepository.setJdbcTemplate(jdbcTemplate);

		Mensaje mensaje = new Mensaje();

		try{
			boolean editarProducto = productoRepository.editarProducto(id,
					producto.getKilos(), producto.getPrecio(), producto.getStock(),producto.getIdUsuario(),
					producto.getIdTipoProducto(), producto.getImg());

			if(editarProducto){
				mensaje.setMsg("Producto con el id: " + id + " editado");

				return mensaje;
			}

			mensaje.setMsg("No se pudo editar el producto con el id: " + id);

			return mensaje;
		}catch (Exception e){
			mensaje.setMsg(e.getMessage());
			e.printStackTrace();

			return mensaje;
		}

	}

	@Override
	public Mensaje borrarProducto(int id) {
		productoRepository.setJdbcTemplate(jdbcTemplate);

		Mensaje mensaje = new Mensaje();

		try{
			boolean borrarProducto = productoRepository.borrarProducto(id);

			if(borrarProducto){
				mensaje.setMsg("Producto con el id: " + id + " borrado");

				return mensaje;
			}

			mensaje.setMsg("No se pudo borrar el producto con el id: " + id);

			return mensaje;
		}catch (Exception e){
			mensaje.setMsg(e.getMessage());
			e.printStackTrace();

			return mensaje;
		}
	}
}

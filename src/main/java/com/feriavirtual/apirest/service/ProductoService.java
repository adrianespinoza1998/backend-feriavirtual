package com.feriavirtual.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Productos;
import com.feriavirtual.apirest.repository.IProductoRepository;

@Service
@Configurable
public class ProductoService implements IProductoService{

	@Autowired
	private IProductoRepository productoRepository;
	
	public ProductoService() {
		
	}
	
	@Override
	public Mensaje crearProducto(JdbcTemplate jdbcTemplate, Productos producto) {
		productoRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje mensaje = new Mensaje();
		
		try {
			
			if(producto.getNombreProducto()!= null) {

				int crearProducto = productoRepository.crearProducto(producto.getNombreProducto().toUpperCase(), 
						producto.getMedidaProducto(), producto.getPrecioProducto(), producto.getStockProducto(),
						producto.getIdRol());
				
				if(crearProducto == 1) {
					
					mensaje.setMsg("Producto " + producto.getNombreProducto() + " creado de forma correcta");
					
					return mensaje;
					
				}
				
				mensaje.setMsg("No se creo el producto " + producto.getNombreProducto());
			}else {
				 mensaje.setMsg("Producto vacío ," + producto.toString());
				 
				 return mensaje;
			}
			
			return mensaje;
		}catch (Exception e) {
			mensaje.setMsg(e.getMessage());
			
			return mensaje;
		}
	}

	@Override
	public List<Productos> listarProductos(JdbcTemplate jdbcTemplate, int idRol) {
		productoRepository.setJdbcTemplate(jdbcTemplate);
		
		return productoRepository.listarProductos(idRol);
	}

	@Override
	public Productos getProductoById(JdbcTemplate jdbcTemplate, int id) {
		productoRepository.setJdbcTemplate(jdbcTemplate);
		
		return productoRepository.buscarProductoPorId(id);
	}

	@Override
	public Mensaje updateProducto(JdbcTemplate jdbcTemplate, Productos producto, int id) {
		
		productoRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();
		
		try {
			int editarProducto = productoRepository.editarProducto(producto.getNombreProducto(), producto.getMedidaProducto(),
					producto.getPrecioProducto(), producto.getStockProducto(), producto.getIdRol(), id);
			
			if(editarProducto == 1) {
				
				objMensaje.setMsg("Producto " + producto.getNombreProducto() + " editado");
				
				return objMensaje;
				
			}
			
			objMensaje.setMsg("No se pudo editar el producto " + producto.getNombreProducto());
			
			return objMensaje;
			
		}catch (Exception e) {
			objMensaje.setMsg(e.getMessage());
			
			return objMensaje;
		}
	}

	@Override
	public Mensaje borrarProducto(JdbcTemplate jdbcTemplate, int id) {
		
		productoRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();
		
		try {
			
			int deleteProducto = productoRepository.borrarProducto(id);
			
			if(deleteProducto == 1) {
				
				objMensaje.setMsg("Producto con el id: " + id + " borrado");
				
				return objMensaje;
				
			}else {
				
				objMensaje.setMsg("No se pudo borrar el producto con el id: " + id);
				return objMensaje;
			}
			
		}catch (Exception e) {
			objMensaje.setMsg(e.getMessage());
			
			return objMensaje;
		}
	}
	
}

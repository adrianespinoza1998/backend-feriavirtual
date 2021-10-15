package com.feriavirtual.apirest.repository.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.feriavirtual.apirest.models.Productos;
import com.feriavirtual.apirest.repository.IProductoRepository;

@Repository
@Configurable
public class ProductoRepositoryImpl implements IProductoRepository{
	
	private JdbcTemplate jdbcTemplate;
	
	public ProductoRepositoryImpl() {
		
	}

	@Override
	public int crearProducto(String nombreProducto, int medidaProducto, int precioProducto, int stockProducto, int idRol) {
		return jdbcTemplate.update(
				 "INSERT INTO PRODUCTOS (ID_PRODUCTO, NOMBRE_PRODUCTO, MEDIDA_PRODUCTO, PRECIO_PRODUCTO,"
				 + "STOCK_PRODUCTO, ID_ROL) VALUES (PRODUCTOS_SEQ.nextval, ?, ?, ?, ?, ?)",
				 new Object[] {nombreProducto, medidaProducto, precioProducto, stockProducto, idRol});
	}

	@Override
	public List<Productos> listarProductos(int idRol) {
        String sql = "SELECT * FROM PRODUCTOS WHERE ID_ROL = ?";
        
        List<Productos> listaProductos = jdbcTemplate.query(sql, 
        		new Object[] { idRol},
        		new int [] {Types.INTEGER},
        		new BeanPropertyRowMapper<Productos>(Productos.class));
        
        return listaProductos;
	}

	@Override
	public Productos buscarProductoPorId(int idProducto) {
		/*try {
			String sql = "SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO = ?";
			
			List<Productos> buscarProductos = jdbcTemplate.query(sql,
			        new Object[] { idProducto },
			        new int[] { Types.INTEGER },
			        new BeanPropertyRowMapper<Productos>(Productos.class));
			
			if(buscarProductos.size()>0) {
				Productos objProductos = buscarProductos.get(0);
				
				return objProductos;

			}else {
				
				return new Productos();
			}
		}catch (Exception e) {
			Productos objProductos = new Productos();
			
			objProductos.setIdProducto(0);
			objProductos.setNombreProducto(e.getMessage());
			
			return objProductos;
		}*/
		return null;
	}

	@Override
	public int editarProducto(String nombreProducto, int medidaProducto, int precioProducto, int stockProducto, int idRol,
			int idProducto) {
		return jdbcTemplate.update("UPDATE PRODUCTOS SET NOMBRE_PRODUCTO = ?, MEDIDA_PRODUCTO = ?, "
				+ "PRECIO_PRODUCTO = ?, STOCK_PRODUCTO = ?, ID_ROL = ? WHERE ID_PRODUCTO = ?", 
				new Object[] {nombreProducto, medidaProducto, precioProducto, stockProducto, idRol,idProducto});
	}

	@Override
	public int borrarProducto(int id) {
		return jdbcTemplate.update("DELETE FROM PRODUCTOS WHERE ID_PRODUCTO = ?", id);
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

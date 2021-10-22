package com.feriavirtual.apirest.repository.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.feriavirtual.apirest.models.Productos;
import com.feriavirtual.apirest.repository.IProductoRepository;

@Repository
@Configurable
public class ProductoRepositoryImpl implements IProductoRepository{

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	public ProductoRepositoryImpl() {
		
	}


	@Override
	public boolean crearProducto(int kilos, int precio, int stock, int idUsuario, int idTipoProducto) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_crear_producto");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_kilos", kilos)
				.addValue("in_precio", precio)
				.addValue("in_stock", stock)
				.addValue("in_id_usuario", idUsuario)
				.addValue("in_id_tipo_producto", idTipoProducto);

		Map out = simpleJdbcCall.execute(in);

		BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

		if(verfOut.intValue() == 0){
			return true;
		}

		return false;
	}

	@Override
	public List<Productos> listarProductos(int idUsuario) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_listar_producto_all")
				.returningResultSet("out_pc_listar_producto",
						BeanPropertyRowMapper.newInstance(Productos.class));

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_usuario", idUsuario);

		Map out = simpleJdbcCall.execute(in);

		if (out == null) {
			return Collections.emptyList();
		} else {
			return (List) out.get("out_pc_listar_producto");
		}
	}

	@Override
	public Productos buscarProductoPorId(int idProducto) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_listar_producto")
				.returningResultSet("out_pc_listar_producto",
						BeanPropertyRowMapper.newInstance(Productos.class));

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_producto", idProducto);

		Map out = simpleJdbcCall.execute(in);

		List<Productos> listaProducto = (List<Productos>) out.get("out_pc_listar_producto");

		if(listaProducto.size()>0){
			Productos objProducto = listaProducto.get(0);
			return objProducto;
		}else{
			return new Productos();
		}
	}

	@Override
	public boolean editarProducto(int id, int kilos, int precio, int stock, int idUsuario, int idTipoProducto) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_actualizar_producto");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_producto", id)
				.addValue("in_kilos", kilos)
				.addValue("in_precio", precio)
				.addValue("in_stock", stock)
				.addValue("in_id_usuario", idUsuario)
				.addValue("in_id_tipo_producto", idTipoProducto);

		Map out = simpleJdbcCall.execute(in);

		BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

		if(verfOut.intValue() == 0){
			return true;
		}

		return false;
	}

	@Override
	public boolean borrarProducto(int id) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_del_producto");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_producto", id);

		Map out = simpleJdbcCall.execute(in);

		BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

		if(verfOut.intValue() == 0){
			return true;
		}
		return false;
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

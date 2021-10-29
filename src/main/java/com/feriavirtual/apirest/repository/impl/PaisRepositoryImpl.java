package com.feriavirtual.apirest.repository.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.feriavirtual.apirest.models.Pais;
import com.feriavirtual.apirest.repository.IPaisRepository;

@Configurable
@Repository
@EnableAutoConfiguration
public class PaisRepositoryImpl implements IPaisRepository {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	public PaisRepositoryImpl() {
		
	}
	
	@Override
	public boolean crearPais(String descripcion) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_crear_pais");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_descripcion", descripcion);

		Map out = simpleJdbcCall.execute(in);

		BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

		if(verfOut.intValue() == 0){
			return true;
		}

		return false;
	}

	@Override
	public List<Pais> listarPaises() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_listar_pais_all")
				.returningResultSet("out_nombre_cursor",
						BeanPropertyRowMapper.newInstance(Pais.class));

		Map out = simpleJdbcCall.execute();

		if (out == null) {
			return Collections.emptyList();
		} else {
			return (List) out.get("out_nombre_cursor");
		}
	}

	@Override
	public Pais buscarPaisPorId(int idPais) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_listar_paises")
				.returningResultSet("out_l_cursor",
						BeanPropertyRowMapper.newInstance(Pais.class));

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_pais", idPais);

		Map out = simpleJdbcCall.execute(in);

		List<Pais> listaPais = (List<Pais>) out.get("out_l_cursor");

		if(listaPais.size()>0){
			Pais objPais = listaPais.get(0);
			return objPais;
		}else{
			return new Pais();
		}
	}

	@Override
	public boolean editarPais(int id, String descripcion) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_actualizar_pais");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_pais", id)
				.addValue("in_descripcion", descripcion);

		Map out = simpleJdbcCall.execute(in);

		BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

		if(verfOut.intValue() == 0){
			return true;
		}

		return false;
	}

	@Override
	public boolean borrarPais(int id) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_del_pais");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_pais", id);

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
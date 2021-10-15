package com.feriavirtual.apirest.repository.impl;

import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.feriavirtual.apirest.models.Pais;
import com.feriavirtual.apirest.repository.IPaisRepository;

@Repository
@Configurable
public class PaisRepositoryImpl implements IPaisRepository {

	private JdbcTemplate jdbcTemplate;

	private SimpleJdbcCall simpleJdbcCallRefCursor;
	
	public PaisRepositoryImpl() {
		
	}
	
	@Override
	public int crearPais(String descripcion) {
		return jdbcTemplate.update(
				 "INSERT INTO PAIS (ID_PAIS, DESCRIPCION) VALUES (PAIS_SEQ.nextval, ?)", descripcion.toUpperCase());
	}

	@Override
	public List<Pais> listarPaises() {
		simpleJdbcCallRefCursor = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("get_paises")
				.returningResultSet("o_c_book",
						BeanPropertyRowMapper.newInstance(Pais.class));

		Map out = simpleJdbcCallRefCursor.execute();

		if (out == null) {
			return Collections.emptyList();
		} else {
			return (List) out.get("o_c_book");
		}
	}

	@Override
	public Pais buscarPaisPorId(int idPais) {
		
		try {
			String sql = "SELECT * FROM pais WHERE id_pais = ?";
			
			List<Pais> buscarPais = jdbcTemplate.query(sql,
			        new Object[] { idPais },
			        new int[] { Types.INTEGER },
			        new BeanPropertyRowMapper<Pais>(Pais.class));
			
			if(buscarPais.size()>0) {
				Pais objPais = buscarPais.get(0);
				
				return objPais;

			}else {
				
				return new Pais();
			}
		}catch (Exception e) {
			Pais objPais = new Pais();
			
			objPais.setIdPais(0);
			objPais.setDescripcion(e.getMessage());
			
			return objPais;
		}
	}

	@Override
	public int editarPais(int id, String descripcion) {
		return jdbcTemplate.update("UPDATE PAIS SET DESCRIPCION = ? WHERE ID_PAIS = ?", descripcion.toUpperCase(), id);
	}

	@Override
	public int borrarPais(int id) {
		return jdbcTemplate.update("DELETE FROM PAIS WHERE ID_PAIS = (?)", id);
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

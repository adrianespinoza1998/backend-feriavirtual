package com.feriavirtual.apirest.repository;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.feriavirtual.apirest.models.Pais;

@Repository
@Configurable
public class PaisRepository implements IPaisRepository {

	private JdbcTemplate jdbcTemplate;
	
	public PaisRepository() {
		
	}
	
	@Override
	public int crearPais(String descripcion) {
		return jdbcTemplate.update(
				 "INSERT INTO PAIS (ID_PAIS, DESCRIPCION) VALUES (PAIS_SEQ.nextval, ?)", descripcion.toUpperCase());
	}

	@Override
	public List<Pais> listarPaises() {
        String sql = "SELECT * FROM pais";
        
        List<Pais> listaPaises = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pais.class));
        
        return listaPaises;
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

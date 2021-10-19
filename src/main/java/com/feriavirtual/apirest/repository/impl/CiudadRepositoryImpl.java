package com.feriavirtual.apirest.repository.impl;

import com.feriavirtual.apirest.models.Ciudad;
import com.feriavirtual.apirest.repository.ICiudadRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Configurable
public class CiudadRepositoryImpl implements ICiudadRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public Map crearCiudad(String descripcion,int idPais) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_ciudad");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_descripcion", descripcion)
                .addValue("in_id_pais", idPais);

        Map out = simpleJdbcCall.execute(in);

        return out;
    }

    @Override
    public List<Ciudad> listarCiudades(int idPais) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_ciudad_all")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(Ciudad.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_pais", idPais);

        Map out = simpleJdbcCall.execute(in);

        return (List) out.get("out_nombre_cursor");
    }

    @Override
    public Ciudad getCiudadById(int idCiudad) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_ciudad")
                .returningResultSet("out_pc_listar_ciudad",
                        BeanPropertyRowMapper.newInstance(Ciudad.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_ciudad", idCiudad);

        Map out = simpleJdbcCall.execute(in);

        List<Ciudad> listaCiudad = (List<Ciudad>) out.get("out_pc_listar_ciudad");

        if(listaCiudad.size()>0){
            Ciudad objCiudad = listaCiudad.get(0);

            return objCiudad;
        }else{
            return new Ciudad();
        }
    }

    @Override
    public Map editarCiudad(int idCiudad, String descripcion, int idPais) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_ciudad");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_ciudad", idCiudad)
                .addValue("in_descripcion", descripcion)
                .addValue("in_id_pais", idPais);

        Map out = simpleJdbcCall.execute(in);

        return out;
    }

    @Override
    public Map borrarCiudad(int idCiudad) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_ciudad");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_ciudad", idCiudad);

        Map out = simpleJdbcCall.execute(in);

        return out;
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return null;
    }

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

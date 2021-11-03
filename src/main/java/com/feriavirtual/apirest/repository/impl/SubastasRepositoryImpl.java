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

import com.feriavirtual.apirest.models.Subastas;
import com.feriavirtual.apirest.repository.ISubastasRepository;

@Configurable
@Repository
@EnableAutoConfiguration
public class SubastasRepositoryImpl implements ISubastasRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public boolean crearSubasta(int idUsuario, int idSolicitudProductos) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_subastas");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_usuario", idUsuario)
                .addValue("in_id_solicitud_productos", idSolicitudProductos);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public List<Subastas> listarSubastas(int idUsuario) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_subastas_all")
                .returningResultSet("out_pc_listar_subastas",
                        BeanPropertyRowMapper.newInstance(Subastas.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_usuario", idUsuario);

        Map out = simpleJdbcCall.execute(in);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_pc_listar_subastas");
        }
    }

    @Override
    public Subastas buscarSubastaXId(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_subastas")
                .returningResultSet("out_pc_listar_subastas",
                        BeanPropertyRowMapper.newInstance(Subastas.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_subastas", id);

        Map out = simpleJdbcCall.execute(in);

        List<Subastas> listaSubastas = (List<Subastas>) out.get("out_pc_listar_subastas");

        if(listaSubastas.size()>0){
            Subastas objSubastas = listaSubastas.get(0);
            return objSubastas;
        }else{
            return new Subastas();
        }
    }

    @Override
    public boolean editarSubasta(int id, int idUsuario, int idSolicitudProductos) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_subastas");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_subastas", id)
                .addValue("in_id_usuario", idUsuario)
                .addValue("in_id_solicitud_productos", idSolicitudProductos);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean borrarSubasta(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_subastas");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_subastas", id);

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

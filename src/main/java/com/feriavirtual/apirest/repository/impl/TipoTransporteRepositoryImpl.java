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

import com.feriavirtual.apirest.models.TipoTransporte;
import com.feriavirtual.apirest.repository.ITipoTransporteRepository;

@Configurable
@Repository
@EnableAutoConfiguration
public class TipoTransporteRepositoryImpl implements ITipoTransporteRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public boolean crearTipoTransporte(String descripcion) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_tipo_transporte");

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
    public List<TipoTransporte> listarTipoTransporte() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_tipo_transporte_all")
                .returningResultSet("out_pc_listar_titran_all",
                        BeanPropertyRowMapper.newInstance(TipoTransporte.class));

        Map out = simpleJdbcCall.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_pc_listar_titran_all");
        }
    }

    @Override
    public TipoTransporte buscarTipoTansportePorId(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_tipo_transporte")
                .returningResultSet("out_pc_listar_titran",
                        BeanPropertyRowMapper.newInstance(TipoTransporte.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_tipo_transporte", id);

        Map out = simpleJdbcCall.execute(in);

        List<TipoTransporte> listaTipoTransporte = (List<TipoTransporte>) out.get("out_pc_listar_titran");

        if(listaTipoTransporte.size()>0){
            TipoTransporte objTipoTransporte = listaTipoTransporte.get(0);
            return objTipoTransporte;
        }else{
            return new TipoTransporte();
        }
    }

    @Override
    public boolean editarTipoTansporte(int id, String descripcion) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_tipo_transporte");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_tipo_transporte", id)
                .addValue("in_descripcion", descripcion);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean borrarTipoTansporte(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_tipo_transporte");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_tipo_transporte", id);

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

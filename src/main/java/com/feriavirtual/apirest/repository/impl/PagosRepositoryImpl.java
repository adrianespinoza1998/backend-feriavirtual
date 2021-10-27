package com.feriavirtual.apirest.repository.impl;

import com.feriavirtual.apirest.models.ContratoJoin;
import com.feriavirtual.apirest.models.Pagos;
import com.feriavirtual.apirest.repository.IPagosRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
@Configurable
public class PagosRepositoryImpl implements IPagosRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public boolean crearPago(int idSubastas, int monto, int tarjeta, int idMoneda) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_pagos");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_subastas", idSubastas)
                .addValue("in_monto", monto)
                .addValue("in_tarjeta", tarjeta)
                .addValue("in_id_moneda", idMoneda);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public List<PagosJoin> listarPagos() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_pago_all")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(PagosJoin.class));

        Map out = simpleJdbcCall.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_nombre_cursor");
        }
    }

    @Override
    public List<PagosJoin> listarPagosXUsuario(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_pago_all")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(PagosJoin.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_usuario", id);

        Map out = simpleJdbcCall.execute(in);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_nombre_cursor");
        }
    }

    @Override
    public PagosJoin getPagoXId(int id) {
        return null;
    }

    @Override
    public boolean editarPago(int id, int idSubastas, int monto, int tarjeta, int idMoneda) {
        return false;
    }

    @Override
    public boolean eliminarPago(int id) {
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

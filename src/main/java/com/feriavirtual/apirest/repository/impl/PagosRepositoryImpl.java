package com.feriavirtual.apirest.repository.impl;

import com.feriavirtual.apirest.models.Pagos;
import com.feriavirtual.apirest.repository.IPagosRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
    public List<Pagos> listarPagos() {
        return null;
    }

    @Override
    public List<Pagos> listarPagosXUsuario(int id) {
        return null;
    }

    @Override
    public Pagos getPagoXId(int id) {
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
        return null;
    }

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

    }
}

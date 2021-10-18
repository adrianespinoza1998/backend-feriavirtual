package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Moneda;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IMonedaService {

    Mensaje crearMoneda(JdbcTemplate jdbcTemplate, Moneda moneda);

    List<Moneda> listarMonedas(JdbcTemplate jdbcTemplate);

    Moneda buscarMonedaXId(JdbcTemplate jdbcTemplate, int idMoneda);

    Mensaje updateMoneda(JdbcTemplate jdbcTemplate, int idMoneda, Moneda moneda);

    Mensaje borrarMoneda(JdbcTemplate jdbcTemplate, int idMoneda);
}

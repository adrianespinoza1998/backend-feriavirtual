package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Moneda;

public interface IMonedaRepository {

    boolean crearMoneda(String descripcion, String sigla);

    List<Moneda> listarMonedas();

    Moneda getMonedaById(int idMoneda);

    boolean editarMoneda(int idMoneda, String descripcion, String sigla);

    boolean borrarMoneda(int idMoneda);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.Moneda;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface IMonedaRepository {

    boolean crearMoneda(String descripcion, String sigla);

    List<Moneda> listarMonedas();

    Moneda getMonedaById(int idMoneda);

    boolean editarMoneda(int idMoneda, String descripcion, String sigla);

    boolean borrarMoneda(int idMoneda);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Ciudad;

public interface ICiudadRepository {

    boolean crearCiudad(String descripcion, int idPais);

    List<Ciudad> listarCiudades(int idPais);

    Ciudad getCiudadById(int idCiudad);

    boolean editarCiudad(int idCiudad, String descripcion, int idPais);

    boolean borrarCiudad(int idCiudad);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

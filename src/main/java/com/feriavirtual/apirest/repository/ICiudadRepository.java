package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.Ciudad;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface ICiudadRepository {

    boolean crearCiudad(String descripcion, int idPais);

    List<Ciudad> listarCiudades(int idPais);

    Ciudad getCiudadById(int idCiudad);

    boolean editarCiudad(int idCiudad, String descripcion, int idPais);

    boolean borrarCiudad(int idCiudad);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.Ciudad;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface ICiudadRepository {

    Map crearCiudad(String descripcion, int idPais);

    List<Ciudad> listarCiudades(int idPais);

    Ciudad getCiudadById(int idCiudad);

    Map editarCiudad(int idCiudad, String descripcion, int idPais);

    Map borrarCiudad(int idCiudad);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

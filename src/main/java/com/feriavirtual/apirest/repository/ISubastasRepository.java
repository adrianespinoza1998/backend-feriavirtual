package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Subastas;

public interface ISubastasRepository {

    boolean crearSubasta (int idUsuario, int idSolicitudProductos);

    List<Subastas> listarSubastas(int idUsuario);

    Subastas buscarSubastaXId (int id);

    boolean editarSubasta (int id, int idUsuario, int idSolicitudProductos);

    boolean borrarSubasta (int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

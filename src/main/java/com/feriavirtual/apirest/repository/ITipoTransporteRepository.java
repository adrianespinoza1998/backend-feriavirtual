package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.TipoTransporte;

public interface ITipoTransporteRepository {

    boolean crearTipoTransporte(String descripcion);

    List<TipoTransporte> listarTipoTransporte ();

    TipoTransporte buscarTipoTansportePorId(int id);

    boolean editarTipoTansporte(int id, String descripcion);

    boolean borrarTipoTansporte(int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

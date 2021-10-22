package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.Productos;
import com.feriavirtual.apirest.models.TipoTransporte;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface ITipoTransporteRepository {

    boolean crearTipoTransporte(String descripcion);

    List<TipoTransporte> listarTipoTransporte ();

    TipoTransporte buscarTipoTansportePorId(int id);

    boolean editarTipoTansporte(int id, String descripcion);

    boolean borrarTipoTansporte(int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

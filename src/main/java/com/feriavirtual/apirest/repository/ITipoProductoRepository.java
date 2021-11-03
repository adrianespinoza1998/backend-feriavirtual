package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.TipoProducto;

public interface ITipoProductoRepository {

    boolean crearTipoProducto(String descripcion);

    List<TipoProducto> listarTipoProducto();

    TipoProducto buscarTipoProductoXId(int id);

    boolean editarTipoProducto(int id, String descripcion);

    boolean borrarTipoProducto(int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

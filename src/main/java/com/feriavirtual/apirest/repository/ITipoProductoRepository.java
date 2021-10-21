package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.TipoProducto;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface ITipoProductoRepository {

    Map crearTipoProducto(String descripcion);

    List<TipoProducto> listarTipoProducto();

    TipoProducto buscarTipoProductoXId(int id);

    Map editarTipoProducto(int id, String descripcion);

    Map borrarTipoProducto(int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

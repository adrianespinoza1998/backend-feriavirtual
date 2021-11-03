package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.DetalleVentaJoin;

public interface IDetVentaRepository {

    boolean crearDetVenta (int idProducto, int cantidad, int precio);

    List<DetalleVentaJoin> listarDetVenta ();

    DetalleVentaJoin buscarDetVentaXId (int id);

    boolean editarDetVenta (int id, int idProducto, int cantidad, int precio);

    boolean eliminarDetVenta (int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

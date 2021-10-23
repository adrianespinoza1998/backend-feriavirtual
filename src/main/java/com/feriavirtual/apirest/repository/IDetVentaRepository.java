package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.DetalleVenta;
import com.feriavirtual.apirest.models.DetalleVentaJoin;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IDetVentaRepository {

    boolean crearDetVenta (int idProducto, int cantidad, int precio);

    List<DetalleVentaJoin> listarDetVenta ();

    DetalleVentaJoin buscarDetVentaXId (int id);

    boolean editarDetVenta (int id, int idProducto, int cantidad, int precio);

    boolean eliminarDetVenta (int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

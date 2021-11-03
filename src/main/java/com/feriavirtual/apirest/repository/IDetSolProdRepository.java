package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.DetalleSolProductos;

public interface IDetSolProdRepository {

    boolean crearDetSolProd (int idProducto, int idSolicitudProductos, int cantidad);

    List<DetalleSolProductos> listarDetSolProd ();

    DetalleSolProductos getDetSolProdXSol (int id);

    DetalleSolProductos getDetSolProdXId (int id);

    boolean editarDetSolProd (int id, int idProducto, int idSolicitudProductos, int cantidad);

    boolean eliminarDetSolProd (int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

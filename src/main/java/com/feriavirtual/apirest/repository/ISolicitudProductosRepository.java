package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.SolicitudProductos;

public interface ISolicitudProductosRepository {

    boolean crearSolicitudProducto(int idUsuario, int idTipoSolicitud, int idEstadoSolicitud);

    List<SolicitudProductos> listarSolicitudProductos (int idEstadoSolicitud);

    List<SolicitudProductos> listarSolicitudProductosXUser(int id);

    SolicitudProductos buscarSolicitudProductoXId (int id);

    boolean editarSolicitudProducto (int id, int idUsuario, int idTipoSolicitud, int idEstadoSolicitud);

    boolean eliminarSolicitudProducto (int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

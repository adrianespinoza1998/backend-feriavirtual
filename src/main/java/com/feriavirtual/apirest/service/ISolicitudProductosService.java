package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.SolicitudProductos;

public interface ISolicitudProductosService {

    Mensaje crearSolicitudProducto(SolicitudProductos objSolProd);

    List<SolicitudProductos> listarSolicitudProductos (int idEstadoSolicitud);

    List<SolicitudProductos> listarSolicitudProductosXUser(int id);

    SolicitudProductos buscarSolicitudProductoXId (int id);

    Mensaje editarSolicitudProducto (int id, SolicitudProductos objSolProd);

    Mensaje borrarSolicitudProducto (int id);
}

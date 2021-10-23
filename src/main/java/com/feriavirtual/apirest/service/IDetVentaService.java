package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.DetalleVenta;
import com.feriavirtual.apirest.models.DetalleVentaJoin;
import com.feriavirtual.apirest.models.Mensaje;

import java.util.List;

public interface IDetVentaService {

    Mensaje crearDetVenta (DetalleVenta objDetVenta);

    List<DetalleVentaJoin> listarDetalleVenta ();

    DetalleVentaJoin buscarDetVentaXId (int id);

    Mensaje updateDetVenta (int id, DetalleVenta objDetVenta);

    Mensaje deleteDetVenta (int id);

}

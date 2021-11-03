package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Pagos;
import com.feriavirtual.apirest.models.PagosJoin;

public interface IPagosService {

    Mensaje crearPago(Pagos pagos);

    List<PagosJoin> listarPagos ();

    List<PagosJoin> listarPagosXUsuario (int id);

    List<PagosJoin> listarPagosXIdSolicitud (int id);

    Pagos getPagoXId (int id);

    Mensaje editarPago (int id, Pagos pagos);

    Mensaje eliminarPago (int id);
}

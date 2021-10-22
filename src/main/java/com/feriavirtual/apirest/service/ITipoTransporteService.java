package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.TipoProducto;
import com.feriavirtual.apirest.models.TipoTransporte;

import java.util.List;

public interface ITipoTransporteService {

    Mensaje crearTipoTransporte(TipoTransporte tipoTransporte);

    List<TipoTransporte> listarTipoTransporte();

    TipoTransporte getTipoTransporteXId(int id);

    Mensaje updateTipoTransporte(int id, TipoTransporte tipoTransporte);

    Mensaje borrarTipoTransporte(int id);


}

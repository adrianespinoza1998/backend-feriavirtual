package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.TipoTransporte;

public interface ITipoTransporteService {

    Mensaje crearTipoTransporte(TipoTransporte tipoTransporte);

    List<TipoTransporte> listarTipoTransporte();

    TipoTransporte getTipoTransporteXId(int id);

    Mensaje updateTipoTransporte(int id, TipoTransporte tipoTransporte);

    Mensaje borrarTipoTransporte(int id);


}

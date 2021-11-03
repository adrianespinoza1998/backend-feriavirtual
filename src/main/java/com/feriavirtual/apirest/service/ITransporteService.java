package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Transportes;


public interface ITransporteService {

    Mensaje crearTransporte (Transportes transportes);

    List<Transportes> listarTransportes ();

    List<Transportes> listarTransportesXUser (int id);

    Transportes buscarTransporteXId(int id);

    Mensaje editarTransporte (int id, Transportes transportes);

    Mensaje borrarTransporte (int id);
}

package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Transportes;

import java.util.List;


public interface ITransporteService {

    Mensaje crearTransporte (Transportes transportes);

    List<Transportes> listarTransportes ();

    List<Transportes> listarTransportesXUser (int id);

    Transportes buscarTransporteXId(int id);

    Mensaje editarTransporte (int id, Transportes transportes);

    Mensaje borrarTransporte (int id);
}

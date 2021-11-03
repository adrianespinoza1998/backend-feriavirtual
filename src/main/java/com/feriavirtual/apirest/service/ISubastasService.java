package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Subastas;

public interface ISubastasService {

    Mensaje crearSubastas (Subastas subastas);

    List<Subastas> listarSubastas (int id);

    Subastas getSubastaXId (int id);

    Mensaje updateSubasta (int id, Subastas subastas);

    Mensaje borrarSubasta (int id);
}

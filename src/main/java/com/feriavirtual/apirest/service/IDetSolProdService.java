package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.DetalleSolProductos;
import com.feriavirtual.apirest.models.Mensaje;

public interface IDetSolProdService {

    Mensaje crearDetSolProd (DetalleSolProductos detSolProd);

    List<DetalleSolProductos> listarDetSolProd ();

    DetalleSolProductos getDetSolProdXSol (int id);

    DetalleSolProductos getDetSolProdXId (int id);

    Mensaje editarDetSolProd (int id, DetalleSolProductos detSolProd);

    Mensaje borrarDetSolProd (int id);
}

package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.DetalleSolProductos;
import com.feriavirtual.apirest.models.Mensaje;
import java.util.List;

public interface IDetSolProdService {

    Mensaje crearDetSolProd (DetalleSolProductos detSolProd);

    List<DetalleSolProductos> listarDetSolProd ();

    DetalleSolProductos getDetSolProdXSol (int id);

    DetalleSolProductos getDetSolProdXId (int id);

    Mensaje editarDetSolProd (int id, DetalleSolProductos detSolProd);

    Mensaje borrarDetSolProd (int id);
}

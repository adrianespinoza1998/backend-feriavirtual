package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.TipoProducto;

public interface ITipoProductoService {

    Mensaje crearTipoProducto(TipoProducto tipoProducto);

    List<TipoProducto> listarTipoProducto();

    TipoProducto getTipoProductoXId(int id);

    Mensaje updateTipoProducto(int id, TipoProducto tipoProducto);

    Mensaje borrarTipoProducto(int id);

}

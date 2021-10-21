package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.TipoProducto;

import java.util.List;

public interface ITipoProductoService {

    Mensaje crearTipoProducto(TipoProducto tipoProducto);

    List<TipoProducto> listarTipoProducto();

    TipoProducto getTipoProductoXId(int id);

    Mensaje updateTipoProducto(int id, TipoProducto tipoProducto);

    Mensaje borrarTipoProducto(int id);

}

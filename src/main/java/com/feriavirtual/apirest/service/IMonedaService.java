package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Moneda;

public interface IMonedaService {

    Mensaje crearMoneda(Moneda moneda);

    List<Moneda> listarMonedas();

    Moneda buscarMonedaXId(int idMoneda);

    Mensaje updateMoneda(int idMoneda, Moneda moneda);

    Mensaje borrarMoneda(int idMoneda);
}

package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Moneda;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IMonedaService {

    Mensaje crearMoneda(Moneda moneda);

    List<Moneda> listarMonedas();

    Moneda buscarMonedaXId(int idMoneda);

    Mensaje updateMoneda(int idMoneda, Moneda moneda);

    Mensaje borrarMoneda(int idMoneda);
}

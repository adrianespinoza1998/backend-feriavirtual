package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.Ciudad;
import com.feriavirtual.apirest.models.Mensaje;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface ICiudadService {

    Mensaje crearCiudad(Ciudad ciudad);

    List<Ciudad> listarCiudades(int idPais);

    Ciudad buscarCiudadXId(int idCiudad);

    Mensaje updateCiudad(int idCiudad, Ciudad ciudad);

    Mensaje borrarCiudad(int idCiudad);
}

package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.Contrato;
import com.feriavirtual.apirest.models.Mensaje;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IContratoService {

    Mensaje crearContrato(Contrato contrato);

    List<Contrato> listarContratos(int firmado);

    List<Contrato> listarContratosXUsuario(int idUsuario, int firmado);

    Contrato buscarContratoPorId(int id);

    Mensaje updateContrato(Contrato contrato, int id);

    Mensaje borrarContrato(int id);
}

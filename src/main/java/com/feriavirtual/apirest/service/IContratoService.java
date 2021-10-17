package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.Contrato;
import com.feriavirtual.apirest.models.Mensaje;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IContratoService {

    Mensaje crearContrato(JdbcTemplate jdbcTemplate, Contrato contrato);

    List<Contrato> listarContratos(JdbcTemplate jdbcTemplate, int firmado);

    List<Contrato> listarContratosXUsuario(JdbcTemplate jdbcTemplate, int idUsuario, int firmado);

    Contrato buscarContratoPorId(JdbcTemplate jdbcTemplate, int id);

    Mensaje updateContrato(JdbcTemplate jdbcTemplate, Contrato contrato, int id);

    Mensaje borrarContrato(JdbcTemplate jdbcTemplate, int id);
}

package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.Contrato;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface IContratoRepository {

    Map crearContrato(int firmado, int idUsuario);

    List<Contrato> listarContratos(int firmado);

    List<Contrato> listarContratosXUsuario(int idUsuario, int firmado);

    Contrato getContrato(int idContrato);

    Map editarContrato(int idContrato, int firmado, int idUsuario);

    Map borrarContrato(int idContrato);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

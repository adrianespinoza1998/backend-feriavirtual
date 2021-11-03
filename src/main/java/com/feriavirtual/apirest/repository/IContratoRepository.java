package com.feriavirtual.apirest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Contrato;
import com.feriavirtual.apirest.models.ContratoJoin;

public interface IContratoRepository {

    boolean crearContrato(int firmado, int idUsuario, String codigo, Date fechaIni, Date fechaFin);

    List<ContratoJoin> listarContratos(int firmado);

    List<ContratoJoin> listarContratosXUsuario(int idUsuario, int firmado);

    Contrato getContrato(int idContrato);

    boolean editarContrato(int id, int firmado, int idUsuario, String codigo, Date fechaIni, Date fechaFin);

    boolean borrarContrato(int idContrato);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

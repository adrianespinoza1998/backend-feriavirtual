package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.Contrato;
import com.feriavirtual.apirest.models.ContratoJoin;
import com.feriavirtual.apirest.models.Mensaje;

public interface IContratoService {

    Mensaje crearContrato(Contrato contrato);

    List<ContratoJoin> listarContratos(int firmado);

    List<ContratoJoin> listarContratosXUsuario(int idUsuario, int firmado);

    Contrato buscarContratoPorId(int id);

    Mensaje updateContrato(Contrato contrato, int id);

    Mensaje borrarContrato(int id);
}

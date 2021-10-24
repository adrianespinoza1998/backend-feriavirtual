package com.feriavirtual.apirest.service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.SubastasTransportes;

import java.util.List;

public interface ISubsTransporteService {

    Mensaje crearSubsTransporte (SubastasTransportes objSubsTran);

    List<SubastasTransportes> listarSubsTransporte ();

    List<SubastasTransportes> listarSubsTranXIdTr (int id);

    SubastasTransportes buscarSubsTranXId (int id);

    SubastasTransportes buscarSubsTranXIdSub (int id);

    Mensaje editarSubsTran (int id, SubastasTransportes objSubsTran);

    Mensaje borrarSubsTran (int id);
}

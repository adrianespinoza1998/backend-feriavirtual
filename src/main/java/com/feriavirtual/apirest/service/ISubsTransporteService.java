package com.feriavirtual.apirest.service;

import java.util.List;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.SubastasTransportes;

public interface ISubsTransporteService {

    Mensaje crearSubsTransporte (SubastasTransportes objSubsTran);

    List<SubastasTransportes> listarSubsTransporte ();

    List<SubastasTransportes> listarSubsTranXIdTr (int id);

    SubastasTransportes buscarSubsTranXId (int id);

    SubastasTransportes buscarSubsTranXIdSub (int id);

    Mensaje editarSubsTran (int id, SubastasTransportes objSubsTran);

    Mensaje borrarSubsTran (int id);
}

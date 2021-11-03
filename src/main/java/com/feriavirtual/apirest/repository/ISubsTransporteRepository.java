package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.SubastasTransportes;

public interface ISubsTransporteRepository {

    boolean crearSubsTransporte (int idSubastas, int idTransporte);

    List<SubastasTransportes> listarSubsTransporte ();

    List<SubastasTransportes> listarSubsTranXIdTr (int id);

    SubastasTransportes buscarSubsTranXId (int id);

    SubastasTransportes buscarSubsTranXIdSub (int id);

    boolean editarSubsTran (int id, int idSubastas, int idTransporte);

    boolean borrarSubsTran (int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

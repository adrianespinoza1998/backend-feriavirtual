package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Transportes;

public interface ITransporteRepository {

    boolean crearTransporte (int idTipoTransporte, String marca, int capacidad, int peso, int idUsuario);

    List<Transportes> listarTransportes ();

    List<Transportes> listarTransportesXUsuario (int id);

    Transportes buscarTransporteXId(int id);

    boolean editarTransporte (int id, int idTipoTransporte, String marca, int capacidad, int peso, int idUsuario);

    boolean borrarTransporte (int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.Transportes;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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

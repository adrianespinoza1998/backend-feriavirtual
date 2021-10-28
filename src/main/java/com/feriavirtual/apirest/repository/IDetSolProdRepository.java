package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.DetalleSolProductos;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IDetSolProdRepository {

    boolean crearDetSolProd (int idProducto, int idSolicitudProductos, int cantidad);

    List<DetalleSolProductos> listarDetSolProd ();

    DetalleSolProductos getDetSolProdXSol (int id);

    DetalleSolProductos getDetSolProdXId (int id);

    boolean editarDetSolProd (int id, DetalleSolProductos detSolProd);

    boolean eliminarDetSolProd (int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

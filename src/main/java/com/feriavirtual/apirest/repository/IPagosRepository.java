package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.Pagos;
import com.feriavirtual.apirest.repository.impl.PagosJoin;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IPagosRepository {

    boolean crearPago(int idSubastas, int monto, int tarjeta, int idMoneda);

    List<PagosJoin> listarPagos ();

    List<PagosJoin> listarPagosXUsuario (int id);

    PagosJoin getPagoXId (int id);

    boolean editarPago (int id, int idSubastas, int monto, int tarjeta, int idMoneda);

    boolean eliminarPago (int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

package com.feriavirtual.apirest.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Pagos;
import com.feriavirtual.apirest.models.PagosJoin;

public interface IPagosRepository {

    boolean crearPago(int idSubastas, int monto, BigInteger tarjeta, int idMoneda);

    List<PagosJoin> listarPagos ();

    List<PagosJoin> listarPagosXUsuario (int id);

    List<PagosJoin> listarPagosXIdSolicitud (int id);

    Pagos getPagoXId (int id);

    boolean editarPago (int id, int idSubastas, int monto, BigInteger tarjeta, int idMoneda);

    boolean eliminarPago (int id);

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

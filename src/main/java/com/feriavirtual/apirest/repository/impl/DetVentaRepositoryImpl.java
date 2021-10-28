package com.feriavirtual.apirest.repository.impl;

import com.feriavirtual.apirest.models.DetalleVentaJoin;
import com.feriavirtual.apirest.repository.IDetVentaRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
@Configurable
public class DetVentaRepositoryImpl implements IDetVentaRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public boolean crearDetVenta(int idProducto, int cantidad, int precio) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_detalle_venta");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_producto", idProducto)
                .addValue("in_cantidad", cantidad)
                .addValue("in_precio", precio);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public List<DetalleVentaJoin> listarDetVenta() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_detalle_venta_all")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(DetalleVentaJoin.class));

        Map out = simpleJdbcCall.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_nombre_cursor");
        }
    }

    @Override
    public DetalleVentaJoin buscarDetVentaXId(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_detalle_venta")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(DetalleVentaJoin.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_det_venta", id);

        Map out = simpleJdbcCall.execute(in);

        List<DetalleVentaJoin> listaDetVenta = (List<DetalleVentaJoin>) out.get("out_nombre_cursor");

        if(listaDetVenta.size()>0){
            DetalleVentaJoin objDetVenta = listaDetVenta.get(0);
            return objDetVenta;
        }else{
            return new DetalleVentaJoin();
        }
    }

    @Override
    public boolean editarDetVenta(int id, int idProducto, int cantidad, int precio) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_detalle_venta");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_detalle_venta", id)
                .addValue("in_id_producto", idProducto)
                .addValue("in_cantidad", cantidad)
                .addValue("in_precio", precio);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean eliminarDetVenta(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_det_venta");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_detalle_venta", id);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }
        return false;
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

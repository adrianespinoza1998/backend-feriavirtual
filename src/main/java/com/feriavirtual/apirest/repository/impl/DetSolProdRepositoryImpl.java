package com.feriavirtual.apirest.repository.impl;

import com.feriavirtual.apirest.models.DetalleSolProductos;
import com.feriavirtual.apirest.repository.IDetSolProdRepository;
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
public class DetSolProdRepositoryImpl implements IDetSolProdRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public boolean crearDetSolProd(int idProducto, int idSolicitudProductos, int cantidad) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_detsol_producto");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_producto", idProducto)
                .addValue("in_id_solicitud_productos", idSolicitudProductos)
                .addValue("in_cantidad", cantidad);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public List<DetalleSolProductos> listarDetSolProd() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_detsol_producto_all")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(DetalleSolProductos.class));

        Map out = simpleJdbcCall.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_nombre_cursor");
        }
    }

    @Override
    public DetalleSolProductos getDetSolProdXSol(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_detsol_producto_xsol")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(DetalleSolProductos.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_solicitud_productos", id);

        Map out = simpleJdbcCall.execute(in);

        List<DetalleSolProductos> listaDetSolProd = (List<DetalleSolProductos>) out.get("out_nombre_cursor");

        if(listaDetSolProd.size()>0){
            DetalleSolProductos objDetSolProd = listaDetSolProd.get(0);
            return objDetSolProd;
        }else{
            return new DetalleSolProductos();
        }
    }

    @Override
    public DetalleSolProductos getDetSolProdXId(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_detsol_producto")
                .returningResultSet("out_pc_detsol",
                        BeanPropertyRowMapper.newInstance(DetalleSolProductos.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_detalle_sol_productos", id);

        Map out = simpleJdbcCall.execute(in);

        List<DetalleSolProductos> listaDetSolProd = (List<DetalleSolProductos>) out.get("out_pc_detsol");

        if(listaDetSolProd.size()>0){
            DetalleSolProductos objDetSolProd = listaDetSolProd.get(0);
            return objDetSolProd;
        }else{
            return new DetalleSolProductos();
        }
    }

    @Override
    public boolean editarDetSolProd(int id, int idProducto, int idSolicitudProductos, int cantidad) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_detsol_producto");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_detalle_sol_productos", id)
                .addValue("in_id_producto", idProducto)
                .addValue("in_id_solicitud_productos", idSolicitudProductos)
                .addValue("in_cantidad", cantidad);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean eliminarDetSolProd(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_detsol_producto");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_detalle_sol_productos", id);

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

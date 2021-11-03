package com.feriavirtual.apirest.repository.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.feriavirtual.apirest.models.SolicitudProductos;
import com.feriavirtual.apirest.repository.ISolicitudProductosRepository;

@Configurable
@Repository
@EnableAutoConfiguration
public class SolicitudProductosRepositoryImpl implements ISolicitudProductosRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public boolean crearSolicitudProducto(int idUsuario, int idTipoSolicitud, int idEstadoSolicitud) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_solici_productos");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_usuario", idUsuario)
                .addValue("in_id_tipo_solicitud", idTipoSolicitud)
                .addValue("in_id_estado_solicitud", idEstadoSolicitud);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public List<SolicitudProductos> listarSolicitudProductos(int idEstadoSolicitud) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_solici_productos_all")
                .returningResultSet("out_cursor_solprod_all",
                        BeanPropertyRowMapper.newInstance(SolicitudProductos.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_estado_solicitud", idEstadoSolicitud);

        Map out = simpleJdbcCall.execute(in);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_cursor_solprod_all");
        }
    }

    @Override
    public List<SolicitudProductos> listarSolicitudProductosXUser(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_solici_productos_usr")
                .returningResultSet("out_cursor_solprod_usr",
                        BeanPropertyRowMapper.newInstance(SolicitudProductos.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_usuario", id);

        Map out = simpleJdbcCall.execute(in);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_cursor_solprod_usr");
        }
    }

    @Override
    public SolicitudProductos buscarSolicitudProductoXId(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_solici_productos")
                .returningResultSet("out_pc_listar_solici_productos",
                        BeanPropertyRowMapper.newInstance(SolicitudProductos.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_solicitud_productos", id);

        Map out = simpleJdbcCall.execute(in);

        List<SolicitudProductos> listaSolicitud = (List<SolicitudProductos>) out.get("out_pc_listar_solici_productos");

        if(listaSolicitud.size()>0){
            SolicitudProductos objSolProd = listaSolicitud.get(0);
            return objSolProd;
        }else{
            return new SolicitudProductos();
        }
    }

    @Override
    public boolean editarSolicitudProducto(int id, int idUsuario, int idTipoSolicitud, int idEstadoSolicitud) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_solici_productos");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_solicitud_productos", id)
                .addValue("in_id_usuario", idUsuario)
                .addValue("in_id_tipo_solicitud", idTipoSolicitud)
                .addValue("in_id_estado_solicitud", idEstadoSolicitud);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean eliminarSolicitudProducto(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_solici_productos");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_solicitud_productos", id);

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

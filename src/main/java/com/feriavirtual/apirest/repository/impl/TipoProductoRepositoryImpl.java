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

import com.feriavirtual.apirest.models.TipoProducto;
import com.feriavirtual.apirest.repository.ITipoProductoRepository;

@Configurable
@Repository
@EnableAutoConfiguration
public class TipoProductoRepositoryImpl implements ITipoProductoRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public boolean crearTipoProducto(String descripcion) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_tipo_producto");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_descripcion", descripcion);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public List<TipoProducto> listarTipoProducto() {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_tipo_producto_all")
                .returningResultSet("out_pc_listar_tiprod_all",
                        BeanPropertyRowMapper.newInstance(TipoProducto.class));

        Map out = simpleJdbcCall.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_pc_listar_tiprod_all");
        }
    }

    @Override
    public TipoProducto buscarTipoProductoXId(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_tipo_producto")
                .returningResultSet("out_pc_listar_tiprod",
                        BeanPropertyRowMapper.newInstance(TipoProducto.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_tipo_producto", id);

        Map out = simpleJdbcCall.execute(in);

        List<TipoProducto> listaTipoProducto = (List<TipoProducto>) out.get("out_pc_listar_tiprod");

        if(listaTipoProducto.size()>0){
            TipoProducto objTipoProducto = listaTipoProducto.get(0);
            return objTipoProducto;
        }else{
            return new TipoProducto();
        }
    }

    @Override
    public boolean editarTipoProducto(int id, String descripcion) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_tipo_producto");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_tipo_producto", id)
                .addValue("in_descripcion", descripcion);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean borrarTipoProducto(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_tipo_producto");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_tipo_producto", id);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

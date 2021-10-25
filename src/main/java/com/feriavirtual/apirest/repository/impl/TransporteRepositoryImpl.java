package com.feriavirtual.apirest.repository.impl;

import com.feriavirtual.apirest.models.TipoTransporte;
import com.feriavirtual.apirest.models.Transportes;
import com.feriavirtual.apirest.repository.ITransporteRepository;
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
public class TransporteRepositoryImpl implements ITransporteRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public boolean crearTransporte(int idTipoTransporte, String marca, int capacidad, int peso, int idUsuario) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_transporte");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_tipo_transporte", idTipoTransporte)
                .addValue("in_marca", marca)
                .addValue("in_capacidad", capacidad)
                .addValue("in_peso", peso)
                .addValue("in_id_usuario", idUsuario);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public List<Transportes> listarTransportes() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_transporte_all")
                .returningResultSet("out_pc_listar_tran_all",
                        BeanPropertyRowMapper.newInstance(Transportes.class));

        Map out = simpleJdbcCall.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_pc_listar_tran_all");
        }
    }

    @Override
    public List<Transportes> listarTransportesXUsuario(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_transporte_usr")
                .returningResultSet("out_pc_listar_tran_usr",
                        BeanPropertyRowMapper.newInstance(Transportes.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_usuario", id);

        Map out = simpleJdbcCall.execute(in);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_pc_listar_tran_usr");
        }
    }

    @Override
    public Transportes buscarTransporteXId(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_transporte")
                .returningResultSet("out_pc_listar_tran",
                        BeanPropertyRowMapper.newInstance(Transportes.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_transporte", id);

        Map out = simpleJdbcCall.execute(in);

        List<Transportes> listaTransporte = (List<Transportes>) out.get("out_pc_listar_tran");

        if(listaTransporte.size()>0){
            Transportes objTransporte = listaTransporte.get(0);
            return objTransporte;
        }else{
            return new Transportes();
        }
    }

    @Override
    public boolean editarTransporte(int id, int idTipoTransporte, String marca, int capacidad, int peso, int idUsuario) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_transporte");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_transporte", id)
                .addValue("in_id_tipo_transporte", idTipoTransporte)
                .addValue("in_marca", marca)
                .addValue("in_capacidad", capacidad)
                .addValue("in_peso", peso)
                .addValue("in_id_usuario", idUsuario);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean borrarTransporte(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_transporte");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_transporte", id);

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

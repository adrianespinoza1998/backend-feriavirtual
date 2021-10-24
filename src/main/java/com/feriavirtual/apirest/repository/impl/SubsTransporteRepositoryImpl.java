package com.feriavirtual.apirest.repository.impl;

import com.feriavirtual.apirest.models.Productos;
import com.feriavirtual.apirest.models.SubastasTransportes;
import com.feriavirtual.apirest.repository.ISubsTransporteRepository;
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
public class SubsTransporteRepositoryImpl implements ISubsTransporteRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public boolean crearSubsTransporte(int idSubastas, int idTransporte) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_subastas_trans");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_subastas", idSubastas)
                .addValue("in_id_transporte", idTransporte);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if (verfOut.intValue() == 0) {
            return true;
        }

        return false;
    }

    @Override
    public List<SubastasTransportes> listarSubsTransporte() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_subastas_trans_all")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(SubastasTransportes.class));

        Map out = simpleJdbcCall.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_nombre_cursor");
        }
    }

    @Override
    public List<SubastasTransportes> listarSubsTranXIdTr(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_subastas_trans_tr")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(SubastasTransportes.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_transporte", id);

        Map out = simpleJdbcCall.execute(in);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_nombre_cursor");
        }
    }

    @Override
    public SubastasTransportes buscarSubsTranXId(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_subastas_trans")
                .returningResultSet("out_pc_listar_subtrans",
                        BeanPropertyRowMapper.newInstance(SubastasTransportes.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_subastas_tr", id);

        Map out = simpleJdbcCall.execute(in);

        List<SubastasTransportes> listaSubsTransporte = (List<SubastasTransportes>)
                out.get("out_pc_listar_subtrans");

        if (listaSubsTransporte.size() > 0) {
            SubastasTransportes subsTran = listaSubsTransporte.get(0);
            return subsTran;
        } else {
            return new SubastasTransportes();
        }
    }

    @Override
    public SubastasTransportes buscarSubsTranXIdSub(int id) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_subastas_trans_sb")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(SubastasTransportes.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_subastas", id);

        Map out = simpleJdbcCall.execute(in);

        List<SubastasTransportes> listaSubsTransporte = (List<SubastasTransportes>)
                out.get("out_nombre_cursor");

        if (listaSubsTransporte.size() > 0) {
            SubastasTransportes subsTran = listaSubsTransporte.get(0);
            return subsTran;
        } else {
            return new SubastasTransportes();
        }
    }


    @Override
    public boolean editarSubsTran(int id, int idSubastas, int idTransporte) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_subastas_trans");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_subastas_tr", id)
                .addValue("in_id_subastas", idSubastas)
                .addValue("in_id_transporte", idTransporte);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean borrarSubsTran(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_subastas_trans");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_subastas_tr", id);

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

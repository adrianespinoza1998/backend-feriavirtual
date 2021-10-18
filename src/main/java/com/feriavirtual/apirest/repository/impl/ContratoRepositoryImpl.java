package com.feriavirtual.apirest.repository.impl;

import com.feriavirtual.apirest.models.Contrato;
import com.feriavirtual.apirest.repository.IContratoRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
@Configurable
public class ContratoRepositoryImpl implements IContratoRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public Map crearContrato(int firmado, int idUsuario) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_contrato");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_firmado", firmado)
                .addValue("in_id_usuario", idUsuario);

        Map out = simpleJdbcCall.execute(in);

        return out;
    }

    @Override
    public List<Contrato> listarContratos(int firmado) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_contrato_all")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(Contrato.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_firmado", firmado);

        Map out = simpleJdbcCall.execute(in);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_nombre_cursor");
        }
    }

    @Override
    public List<Contrato> listarContratosXUsuario(int idUsuario,int firmado) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_contrato_x_usuario")
                .returningResultSet("out_pc_listar_contrato",
                        BeanPropertyRowMapper.newInstance(Contrato.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_firmado", firmado)
                .addValue("in_id_usuario", idUsuario);

        Map out = simpleJdbcCall.execute(in);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_pc_listar_contrato");
        }
    }

    @Override
    public Contrato getContrato(int idContrato) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_contrato")
                .returningResultSet("out_pc_listar_contrato",
                        BeanPropertyRowMapper.newInstance(Contrato.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_contrato", idContrato);

        Map out = simpleJdbcCall.execute(in);

        List<Contrato> listaContrato = (List<Contrato>) out.get("out_pc_listar_contrato");

        if(listaContrato.size()>0){
            Contrato objContrato = listaContrato.get(0);

            return objContrato;
        }else{
            return new Contrato();
        }
    }

    @Override
    public Map editarContrato(int idContrato, int firmado, int idUsuario) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_contrato");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_contrato", idContrato)
                .addValue("in_firmado", firmado)
                .addValue("in_id_usuario", idUsuario);

        Map out = simpleJdbcCall.execute(in);

        return out;
    }

    @Override
    public Map borrarContrato(int idContrato) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_contrato");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_contrato", idContrato);

        Map out = simpleJdbcCall.execute(in);

        return out;
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

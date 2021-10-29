package com.feriavirtual.apirest.repository.impl;

import com.feriavirtual.apirest.models.Moneda;
import com.feriavirtual.apirest.repository.IMonedaRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Configurable
@Repository
@EnableAutoConfiguration
public class MonedaRepositoryImpl implements IMonedaRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public boolean crearMoneda(String descripcion, String sigla) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_moneda");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_sigla", sigla)
                .addValue("in_descripcion", descripcion);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public List<Moneda> listarMonedas() {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_moneda_all")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(Moneda.class));

        Map out = simpleJdbcCall.execute();

        return (List) out.get("out_nombre_cursor");
    }

    @Override
    public Moneda getMonedaById(int idMoneda) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_moneda")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(Moneda.class));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_moneda", idMoneda);

        Map out = simpleJdbcCall.execute(in);

        List<Moneda> listaMoneda = (List<Moneda>) out.get("out_nombre_cursor");

        if(listaMoneda.size()>0){
            Moneda objMoneda = listaMoneda.get(0);

            return objMoneda;
        }else{
            return new Moneda();
        }

    }

    @Override
    public boolean editarMoneda(int idMoneda, String descripcion, String sigla) {

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_moneda");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_moneda", idMoneda)
                .addValue("in_sigla", descripcion)
                .addValue("in_descripcion", sigla);

        Map out = simpleJdbcCall.execute(in);

        BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

        if(verfOut.intValue() == 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean borrarMoneda(int idMoneda) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_del_moneda");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id_moneda", idMoneda);

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

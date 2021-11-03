package com.feriavirtual.apirest.repository.impl;

import com.feriavirtual.apirest.models.Roles;
import com.feriavirtual.apirest.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Configurable
@Repository
@EnableAutoConfiguration
public class RolRepositoryImpl implements IRolRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public List<Roles> listarRoles() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listar_roles_all")
                .returningResultSet("out_nombre_cursor",
                        BeanPropertyRowMapper.newInstance(Roles.class));

        Map out = simpleJdbcCall.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("out_nombre_cursor");
        }
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

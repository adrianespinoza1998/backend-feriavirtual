package com.feriavirtual.apirest.repository;

import com.feriavirtual.apirest.models.Roles;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IRolRepository {

    List<Roles> listarRoles();

    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

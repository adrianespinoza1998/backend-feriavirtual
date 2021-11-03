package com.feriavirtual.apirest.service.impl;

import com.feriavirtual.apirest.models.Roles;
import com.feriavirtual.apirest.repository.IRolRepository;
import com.feriavirtual.apirest.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Configurable
@Service
@EnableAutoConfiguration

public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Roles> listarRoles() {
        rolRepository.setJdbcTemplate(jdbcTemplate);
        return rolRepository.listarRoles();
    }
}

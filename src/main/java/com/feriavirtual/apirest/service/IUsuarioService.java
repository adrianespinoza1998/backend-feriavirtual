package com.feriavirtual.apirest.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Usuario;

public interface IUsuarioService {

	Mensaje crearUsuario(JdbcTemplate jdbcTemplate, Usuario usuario) throws SQLException;
	
	List<Usuario> listarUsuarios(JdbcTemplate jdbcTemplate, int idEstado);
	
	Usuario buscarUsuarioPorId(JdbcTemplate jdbcTemplate, int id);
	
	Mensaje updateUsuario(JdbcTemplate jdbcTemplate, Usuario usuario, int id);
	
	Mensaje borrarUsuario(JdbcTemplate jdbcTemplate, int id);
	
	Usuario verificarUsuario (JdbcTemplate jdbcTemplate, Usuario usuario);
}

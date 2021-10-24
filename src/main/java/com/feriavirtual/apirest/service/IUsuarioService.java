package com.feriavirtual.apirest.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.feriavirtual.apirest.models.UsuarioJoin;
import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Usuario;

public interface IUsuarioService {

	Mensaje crearUsuario(Usuario usuario);

	List<UsuarioJoin> listarUsuarios(int idEstado);
	
	Usuario buscarUsuarioPorId(int id);
	
	Mensaje updateUsuario(Usuario usuario, int id);

	Mensaje borrarUsuario(int id);
	
	Usuario verificarUsuario (Usuario usuario);
}

package com.feriavirtual.apirest.repository;

import java.util.List;
import java.util.Map;

import com.feriavirtual.apirest.models.UsuarioJoin;
import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Usuario;

public interface IUsuarioRepository {
	
	Map crearUsuario(String nombre, String apPaterno, String apMaterno, String dni, String direccion, String codPostal,
					 String correo, String usuario, String contrasena, int idPais, int idRol, int idEstado, int terminosCondiciones);

	List<UsuarioJoin> listarUsuarios(int idEstado);
	
	Usuario buscarUsuarioPorId(int idUsuario);
	
	Map editarUsuario(String nombre, String apPaterno, String apMaterno, String dni, String direccion, String codPostal,
			String correo, String usuario, String contrasena, int idPais, int idRol, int termCond, int idUsuario);
	
	Map borrarUsuario(int idUsuario);
	
	Usuario verificarUsuario(String correo);
	
	JdbcTemplate getJdbcTemplate();
	
	void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

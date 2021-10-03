package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Usuario;

public interface IUsuarioRepository {
	
	int crearUsuario(String nombre, String apPaterno, String apMaterno, String dni, String direccion, 
			String correo, String usuario, String contrasena, int idPais, int idRol, int idEstado, int idEmpresa);
	
	List<Usuario> listarUsuarios(int idEmpresa);
	
	Usuario buscarUsuarioPorId(int idUsuario);
	
	int editarUsuario(String nombre, String apPaterno, String apMaterno, String dni, String direccion, 
			String correo, String usuario, String contrasena, int idPais, int idRol, int idEstado, int idEmpresa, int idUsuario);
	
	int borrarUsuario(int idUsuario);
	
	Usuario verificarUsuario(String correo);
	
	JdbcTemplate getJdbcTemplate();
	
	void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

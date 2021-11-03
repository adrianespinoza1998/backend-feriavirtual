package com.feriavirtual.apirest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.feriavirtual.apirest.models.Usuario;
import com.feriavirtual.apirest.models.UsuarioJoin;

public interface IUsuarioRepository {
	
	boolean crearUsuario(String nombre, String apPaterno, String apMaterno, String dni, String direccion, String codPostal,
					 String correo, String usuario, String contrasena, int idPais, int idRol, int idEstado, int terminosCondiciones);

	List<UsuarioJoin> listarUsuarios(int idEstado);
	
	Usuario buscarUsuarioPorId(int idUsuario);
	
	boolean editarUsuario(int id, String nombre, String apPaterno, String apMaterno, String dni, String direccion, String codPostal,
			String correo, String usuario, String contrasena, int idPais, int idRol, int termCond);
	
	boolean cambiarEstadoUsuario(int idUsuario, int estado);
	
	Usuario verificarUsuario(String correo);
	
	JdbcTemplate getJdbcTemplate();
	
	void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}

package com.feriavirtual.apirest.repository.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.feriavirtual.apirest.models.Usuario;
import com.feriavirtual.apirest.repository.IUsuarioRepository;

@Repository
@Configurable
public class UsuarioRepositoryImpl implements IUsuarioRepository{
	
	private JdbcTemplate jdbcTemplate;
	
	public UsuarioRepositoryImpl() {
		
	}

	@Override
	public int crearUsuario(String nombre, String apPaterno, String apMaterno, String dni, String direccion,
			String correo, String usuario, String contrasena,int idPais, int idRol, int idEstado, int idEmpresa) {
		return jdbcTemplate.update(
				 "INSERT INTO USUARIO VALUES (USUARIO_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				 new Object[] {nombre, apPaterno, apMaterno, dni, direccion, correo, usuario, contrasena, idPais, 
						 idRol, idEmpresa, idEmpresa});
	}

	@Override
	public List<Usuario> listarUsuarios(int idEmpresa) {
        String sql = "SELECT * FROM USUARIO WHERE ID_EMPRESA = ?";
        
        List<Usuario> listaUsuarios = jdbcTemplate.query(sql, 
        		new Object[] { idEmpresa},
        		new int [] {Types.INTEGER},
        		new BeanPropertyRowMapper<Usuario>(Usuario.class));
        
        return listaUsuarios;
	}

	@Override
	public Usuario buscarUsuarioPorId(int idUsuario) {
		try {
			String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";
			
			List<Usuario> buscarUsuario = jdbcTemplate.query(sql,
			        new Object[] { idUsuario },
			        new int[] { Types.INTEGER },
			        new BeanPropertyRowMapper<Usuario>(Usuario.class));
			
			if(buscarUsuario.size()>0) {
				Usuario objUsuario = buscarUsuario.get(0);
				
				return objUsuario;

			}else {
				
				return new Usuario();
			}
		}catch (Exception e) {
			Usuario objUsuario = new Usuario();
			
			objUsuario.setIdUsuario(0);
			objUsuario.setNombre(e.getMessage());
			
			return objUsuario;
		}
	}

	@Override
	public int editarUsuario(String nombre, String apPaterno, String apMaterno, String dni, String direccion,
			String correo, String usuario, String contrasena,int idPais, int idRol, int idEstado, int idEmpresa, 
			int idUsuario) {
		
		return jdbcTemplate.update("UPDATE USUARIO SET NOMBRE = ?, AP_PATERNO = ?, AP_MATERNO = ?, DNI = ?, "
				+ "DIRECCION = ?, CORREO = ?, USUARIO = ?, CONTRASENA = ?, ID_PAIS = ?, ID_ROL = ?,"
				+ "ID_ESTADO = ?, ID_EMPRESA = ? WHERE ID_USUARIO = ?", 
				new Object[] {nombre, apPaterno, apMaterno, dni, direccion, correo, usuario, contrasena, idPais,
						idRol, idEstado, idEmpresa, idUsuario});
	}

	@Override
	public int borrarUsuario(int idUsuario) {
		return jdbcTemplate.update("DELETE FROM USUARIO WHERE ID_USUARIO = ?", idUsuario);
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

package com.feriavirtual.apirest.repository.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.feriavirtual.apirest.models.UsuarioJoin;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.feriavirtual.apirest.models.Usuario;
import com.feriavirtual.apirest.repository.IUsuarioRepository;

@Configurable
@Repository
@EnableAutoConfiguration
public class UsuarioRepositoryImpl implements IUsuarioRepository{
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	public UsuarioRepositoryImpl() {
		
	}

	@Override
	public boolean crearUsuario(String nombre, String apPaterno, String apMaterno, String dni, String direccion, String codPostal, String correo, String usuario, String contrasena, int idPais, int idRol, int idEstado, int terminosCondiciones) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_crear_usuario");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_nombre", nombre)
				.addValue("in_ap_paterno", apPaterno)
				.addValue("in_ap_materno", apMaterno)
				.addValue("in_dni", dni)
				.addValue("in_direccion", direccion)
				.addValue("in_cod_postal", codPostal)
				.addValue("in_correo", correo)
				.addValue("in_usuario", usuario)
				.addValue("in_contrasena", contrasena)
				.addValue("in_id_pais", idPais)
				.addValue("in_id_rol", idRol)
				.addValue("in_id_estado", idEstado)
				.addValue("in_terminos_condiciones", terminosCondiciones);

		Map out = simpleJdbcCall.execute(in);

		BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

		if(verfOut.intValue() == 0){
			return true;
		}

		return false;
	}

	@Override
	public List<UsuarioJoin> listarUsuarios(int idEstado) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_listar_usuarios_all")
				.returningResultSet("out_nombre_cursor",
						BeanPropertyRowMapper.newInstance(UsuarioJoin.class));

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_estado", idEstado);

		Map out = simpleJdbcCall.execute(in);

		List<UsuarioJoin> listaUsuario = (List<UsuarioJoin>) out.get("out_nombre_cursor");

		return listaUsuario;
	}

	@Override
	public Usuario buscarUsuarioPorId(int idUsuario) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_listar_usuario")
				.returningResultSet("out_nombre_cursor",
						BeanPropertyRowMapper.newInstance(Usuario.class));

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_usuario", idUsuario);

		Map out = simpleJdbcCall.execute(in);

		List<Usuario> listaUsuario = (List<Usuario>) out.get("out_nombre_cursor");

		if(listaUsuario.size()>0){
			Usuario objUsuario = listaUsuario.get(0);

			return objUsuario;
		}else{
			return new Usuario();
		}
	}

	@Override
	public boolean editarUsuario(int id, String nombre, String apPaterno, String apMaterno, String dni, String direccion, String codPostal, String correo, String usuario, String contrasena, int idPais, int idRol, int termCond) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_actualizar_usuario");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_usuario", id)
				.addValue("in_nombre", nombre)
				.addValue("in_ap_paterno", apPaterno)
				.addValue("in_ap_materno", apMaterno)
				.addValue("in_dni", dni)
				.addValue("in_direccion", direccion)
				.addValue("in_cod_postal", codPostal)
				.addValue("in_correo", correo)
				.addValue("in_usuario", usuario)
				.addValue("in_contrasena", contrasena)
				.addValue("in_id_pais", idPais)
				.addValue("in_id_rol", idRol)
				.addValue("in_terminos_condiciones", termCond);

		Map out = simpleJdbcCall.execute(in);
		BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

		if(verfOut.intValue() == 0){
			return true;
		}

		return false;
	}

	@Override
	public boolean cambiarEstadoUsuario(int idUsuario, int estado) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_desactivar_usuario");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_usuario", idUsuario)
				.addValue("in_id_estado", estado);
		Map out = simpleJdbcCall.execute(in);

		BigDecimal verfOut = (BigDecimal) out.get("OUT_ESTADO");

		if(verfOut.intValue() == 0){
			return true;
		}

		return false;
	}

	@Override
	public Usuario verificarUsuario(String correo) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_verificar_usuario")
				.returningResultSet("out_pc_get_usuario",
						BeanPropertyRowMapper.newInstance(Usuario.class));

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_correo", correo);

		Map out = simpleJdbcCall.execute(in);

		List<Usuario> listaUsuario = (List<Usuario>) out.get("out_pc_get_usuario");

		if(listaUsuario.size()>0){
			Usuario objUsuario = listaUsuario.get(0);

			return objUsuario;
		}else{
			return new Usuario();
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

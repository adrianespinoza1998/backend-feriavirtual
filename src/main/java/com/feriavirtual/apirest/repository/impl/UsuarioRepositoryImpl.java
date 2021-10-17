package com.feriavirtual.apirest.repository.impl;

import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.feriavirtual.apirest.models.Usuario;
import com.feriavirtual.apirest.repository.IUsuarioRepository;

@Repository
@Configurable
public class UsuarioRepositoryImpl implements IUsuarioRepository{
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	public UsuarioRepositoryImpl() {
		
	}

	@Override
	public Map crearUsuario(String nombre, String apPaterno, String apMaterno, String dni, String direccion, String codPostal, String correo, String usuario, String contrasena, int idPais, int idRol, int idEstado, int terminosCondiciones) {
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
				.addValue("in_terminos_condiciones", terminosCondiciones)
				.addValue("out_glosa","SP_CREAR_USUARIO ejecutado exitosamente")
				.addValue("out_estado",0)
				.addValue("out_id_usuario",0);

		Map out = simpleJdbcCall.execute(in);

		return out;
	}

	@Override
	public List<Usuario> listarUsuarios(int idEstado) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_listar_usuarios_all")
				.returningResultSet("out_nombre_cursor",
						BeanPropertyRowMapper.newInstance(Usuario.class));

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_estado", idEstado)
				.addValue("out_glosa", "SP_LISTAR_USUARIOS_ALL ejecutado exitosamente")
				.addValue("out_estado", 0);

		Map out = simpleJdbcCall.execute(in);

		if (out == null) {
			return Collections.emptyList();
		} else {
			return (List) out.get("out_nombre_cursor");
		}
	}

	@Override
	public Usuario buscarUsuarioPorId(int idUsuario) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_listar_usuario")
				.returningResultSet("out_nombre_cursor",
						BeanPropertyRowMapper.newInstance(Usuario.class));

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_usuario", idUsuario)
				.addValue("out_glosa", "SP_LISTAR_USUARIO ejecutado exitosamente")
				.addValue("out_estado", 0);

		Map out = simpleJdbcCall.execute(in);

		List<Usuario> listaUsuario = (List<Usuario>) out.get("out_nombre_cursor");
		Usuario objUsuario = listaUsuario.get(0);
		objUsuario.setIdUsuario(idUsuario);

		return objUsuario;
	}

	@Override
	public Map editarUsuario(String nombre, String apPaterno, String apMaterno, String dni, String direccion, String codPostal, String correo, String usuario, String contrasena, int idPais, int idRol, int termCond, int idUsuario) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_actualizar_usuario");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_usuario", idUsuario)
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
				.addValue("in_terminos_condiciones", termCond)
				.addValue("out_glosa","SP_UPD_USUARIO ejecutado exitosamente")
				.addValue("out_estado",0)
				.addValue("out_id_usuario",0);

		Map out = simpleJdbcCall.execute(in);

		return out;
	}

	@Override
	public Map borrarUsuario(int idUsuario) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_desactivar_usuario");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_id_usuario", idUsuario)
				.addValue("in_id_estado", 2)
				.addValue("out_glosa","SP_DESACTIVAR_USUARIO ejecutado exitosamente")
				.addValue("out_estado",0);

		Map out = simpleJdbcCall.execute(in);
		return out;
	}

	@Override
	public Usuario verificarUsuario(String correo) {

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sp_verificar_usuario")
				.returningResultSet("out_pc_get_usuario",
						BeanPropertyRowMapper.newInstance(Usuario.class));

		simpleJdbcCall.declareParameters(
				new SqlParameter("in_correo", Types.VARCHAR),
				new SqlParameter("out_glosa", Types.VARCHAR),
				new SqlParameter("out_estado",Types.INTEGER));

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("in_correo", correo)
				.addValue("out_glosa","SP_VERIFICAR_USUARIO ejecutado exitosamente")
				.addValue("out_estado",0);

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

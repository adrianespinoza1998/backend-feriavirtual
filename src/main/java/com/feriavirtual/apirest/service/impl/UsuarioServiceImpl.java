package com.feriavirtual.apirest.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Usuario;
import com.feriavirtual.apirest.repository.IUsuarioRepository;
import com.feriavirtual.apirest.service.IUsuarioService;

@Service
@Configurable
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	public IUsuarioRepository usuarioRepository;
	
	@Override
	public Mensaje crearUsuario(JdbcTemplate jdbcTemplate, Usuario usuario) {
		
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje mensaje = new Mensaje();
		
		try {
			
			if(usuario.getNombre()!=null || !usuario.getNombre().equals("")) {

				String contrasena = encriptarPassword(usuario.getContrasena());

				Map crearUsuario = usuarioRepository.crearUsuario(usuario.getNombre().toUpperCase(),
						usuario.getApPaterno().toUpperCase(), usuario.getApMaterno().toUpperCase(), 
						usuario.getDni().toUpperCase(), usuario.getDireccion().toUpperCase(), usuario.getCodPostal(),
						usuario.getCorreo().toUpperCase(), usuario.getUsuario(), contrasena,
						usuario.getIdPais(), usuario.getIdRol(), usuario.getIdEstado(), usuario.getTerminosCondiciones());

				BigDecimal verCrearUsuario = (BigDecimal) crearUsuario.get("OUT_ESTADO");

				if(verCrearUsuario.intValue() == 0) {
					
					mensaje.setMsg("Usuario " + usuario.getNombre() + " creado de forma correcta");
					
					return mensaje;
					
				}
				
				mensaje.setMsg("No se creo el usuario " + usuario.getNombre() + ", error: " + (String) crearUsuario.get("OUT_GLOSA"));
			}else {
				 mensaje.setMsg("Usuario vacío ," + usuario.toString());

			}
			
			return mensaje;
		}catch (Exception e) {
			mensaje.setMsg(e.getMessage());

			e.printStackTrace();
			
			return mensaje;
		}
	}

	@Override
	public List<Usuario> listarUsuarios(JdbcTemplate jdbcTemplate, int idEstado) {
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		return usuarioRepository.listarUsuarios(idEstado);
	}

	@Override
	public Usuario buscarUsuarioPorId(JdbcTemplate jdbcTemplate, int id) {
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		return usuarioRepository.buscarUsuarioPorId(id);
	}

	@Override
	public Mensaje updateUsuario(JdbcTemplate jdbcTemplate, Usuario usuario, int id) {

		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		Mensaje objMensaje = new Mensaje();

		try{
			Map updateUsuario = usuarioRepository.editarUsuario(usuario.getNombre(),usuario.getApPaterno(),
					usuario.getApMaterno(),usuario.getDni(),usuario.getDireccion(),usuario.getCodPostal(),
					usuario.getCorreo(),usuario.getUsuario(),usuario.getContrasena(),usuario.getIdPais()
					,usuario.getIdRol(),usuario.getTerminosCondiciones(),usuario.getIdUsuario());

			BigDecimal verUpdUsuario = (BigDecimal) updateUsuario.get("OUT_ESTADO");

			if(verUpdUsuario.intValue() == 0){
				objMensaje.setMsg("Usuario con el id: " + id + " actualizado");
			}else {
				objMensaje.setMsg("No se pudo actaulizar el usuario con el id: " + id);
			}

			return objMensaje;

		}catch (Exception e){
			objMensaje.setMsg(e.getMessage());

			return objMensaje;
		}
	}

	@Override
	public Mensaje borrarUsuario(JdbcTemplate jdbcTemplate, int id) {
		
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();
		
		try {
			
			Map deleteUsuario = usuarioRepository.borrarUsuario(id);

			BigDecimal verDeleteUsuario = (BigDecimal) deleteUsuario.get("OUT_ESTADO");
			
			if(verDeleteUsuario.intValue() == 0) {
				
				objMensaje.setMsg("Usuario con el id: " + id + " borrado");

			}else {
				
				objMensaje.setMsg("No se pudo borrar el usuario con el id: " + id);
			}
			return objMensaje;

		}catch (Exception e) {
			objMensaje.setMsg(e.getMessage());
			e.printStackTrace();
			
			return objMensaje;
		}
	}

	@Override
	public Usuario verificarUsuario(JdbcTemplate jdbcTemplate, Usuario usuario) {
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		Usuario buscarUsuario= usuarioRepository.verificarUsuario(usuario.getCorreo().toUpperCase());

		if(verificarPassword(usuario.getContrasena(), buscarUsuario.getContrasena())){
			return buscarUsuario;
		}else{
			return new Usuario();
		}
	}

	private String encriptarPassword(String password){
		String result = DigestUtils.sha256Hex(password);
		return result;
	}

	private boolean verificarPassword(String password, String hex){
		return DigestUtils.sha256Hex(password).equals(hex);
	}
}
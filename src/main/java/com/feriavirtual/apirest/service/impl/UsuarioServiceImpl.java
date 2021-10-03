package com.feriavirtual.apirest.service.impl;

import java.util.List;

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

				int crearUsuario = usuarioRepository.crearUsuario(usuario.getNombre().toUpperCase(), 
						usuario.getApPaterno().toUpperCase(), usuario.getApMaterno().toUpperCase(), 
						usuario.getDni().toUpperCase(), usuario.getDireccion().toUpperCase(), 
						usuario.getCorreo().toUpperCase(), usuario.getUsuario(), contrasena,
						usuario.getIdPais(), usuario.getIdRol(), usuario.getIdEstado(), usuario.getIdEmpresa());

				if(crearUsuario == 1) {
					
					mensaje.setMsg("Usuario " + usuario.getNombre() + " creado de forma correcta");
					
					return mensaje;
					
				}
				
				mensaje.setMsg("No se creo el usuario " + usuario.getNombre());
			}else {
				 mensaje.setMsg("Usario vacío ," + usuario.toString());
				 
				 return mensaje;
			}
			
			return mensaje;
		}catch (Exception e) {
			mensaje.setMsg(e.getMessage());
			
			return mensaje;
		}
	}

	@Override
	public List<Usuario> listarUsuarios(JdbcTemplate jdbcTemplate, int idEmpresa) {
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		return usuarioRepository.listarUsuarios(idEmpresa);
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
		
		try {
			String contrasena = encriptarPassword(usuario.getContrasena());

			int editarUsuario = usuarioRepository.editarUsuario(usuario.getNombre().toUpperCase(), 
					usuario.getApPaterno().toUpperCase(), usuario.getApMaterno().toUpperCase(), 
					usuario.getDni().toUpperCase(), usuario.getDireccion().toUpperCase(), 
					usuario.getCorreo().toUpperCase(), usuario.getUsuario(), contrasena,
					usuario.getIdPais(), usuario.getIdRol(), usuario.getIdEstado(), usuario.getIdEmpresa(), id);
			
			if(editarUsuario == 1) {
				
				objMensaje.setMsg("Usuario " + usuario.getNombre() + " editado");
				
				return objMensaje;
				
			}
			
			objMensaje.setMsg("No se pudo editar el usuario " + usuario.getNombre());
			
			return objMensaje;
			
		}catch (Exception e) {
			objMensaje.setMsg(e.getMessage());
			
			return objMensaje;
		}
	}

	@Override
	public Mensaje borrarUsuario(JdbcTemplate jdbcTemplate, int id) {
		
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();
		
		try {
			
			int deleteUsuario = usuarioRepository.borrarUsuario(id);
			
			if(deleteUsuario == 1) {
				
				objMensaje.setMsg("Usuario con el id: " + id + " borrado");
				
				return objMensaje;
				
			}else {
				
				objMensaje.setMsg("No se pudo borrar el usuario con el id: " + id);
				return objMensaje;
			}
			
		}catch (Exception e) {
			objMensaje.setMsg(e.getMessage());
			
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
			Usuario objUsuario = new Usuario();
			objUsuario.setNombre(buscarUsuario.getContrasena());
			objUsuario.setContrasena(usuario.getContrasena());

			return objUsuario;
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
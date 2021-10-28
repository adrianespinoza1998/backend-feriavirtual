package com.feriavirtual.apirest.service.impl;

import java.util.List;

import com.feriavirtual.apirest.models.UsuarioJoin;
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
	private IUsuarioRepository usuarioRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Mensaje crearUsuario(Usuario usuario) {
		
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje mensaje = new Mensaje();
		
		try {
			
			if(usuario.getNombre()!=null || !usuario.getNombre().equals("")) {

				String contrasena = encriptarPassword(usuario.getContrasena());

				boolean crearUsuario = usuarioRepository.crearUsuario(usuario.getNombre().toUpperCase(),
						usuario.getApPaterno().toUpperCase(), usuario.getApMaterno().toUpperCase(), 
						usuario.getDni().toUpperCase(), usuario.getDireccion().toUpperCase(), usuario.getCodPostal(),
						usuario.getCorreo().toUpperCase(), usuario.getUsuario(), contrasena,
						usuario.getIdPais(), usuario.getIdRol(), usuario.getIdEstado(), usuario.getTerminosCondiciones());

				if(crearUsuario) {
					
					mensaje.setMsg("Usuario " + usuario.getNombre() + " creado de forma correcta");
					
					return mensaje;
					
				}
				
				mensaje.setMsg("No se creo el usuario " + usuario.getNombre());
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
	public List<UsuarioJoin> listarUsuarios(int idEstado) {
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		return usuarioRepository.listarUsuarios(idEstado);
	}

	@Override
	public Usuario buscarUsuarioPorId(int id) {
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		return usuarioRepository.buscarUsuarioPorId(id);
	}

	@Override
	public Mensaje updateUsuario(Usuario usuario, int id) {

		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		Mensaje objMensaje = new Mensaje();

		try{

			String contrasenaCrypt = null;

			if(usuario.getContrasena()!=null){
				contrasenaCrypt = encriptarPassword(usuario.getContrasena());
			}

			boolean updateUsuario = usuarioRepository.editarUsuario(id, usuario.getNombre().toUpperCase(),
					usuario.getApPaterno().toUpperCase(), usuario.getApMaterno().toUpperCase(), usuario.getDni(),
					usuario.getDireccion().toUpperCase(), usuario.getCodPostal(), usuario.getCorreo().toUpperCase(),
					usuario.getUsuario(), contrasenaCrypt, usuario.getIdPais(), usuario.getIdRol(),
					usuario.getTerminosCondiciones());

			if(updateUsuario){
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
	public Mensaje borrarUsuario(int id, int estado) {
		
		usuarioRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();
		
		try {
			
			boolean deleteUsuario = usuarioRepository.borrarUsuario(id, estado);
			
			if(deleteUsuario) {
				
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
	public Usuario verificarUsuario(Usuario usuario) {
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
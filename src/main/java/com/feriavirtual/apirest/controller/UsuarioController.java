package com.feriavirtual.apirest.controller;

import java.util.List;

import com.feriavirtual.apirest.models.UsuarioJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Usuario;
import com.feriavirtual.apirest.service.IUsuarioService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/api/usuario")
	public Mensaje crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.crearUsuario(usuario);
	}
	
	@PostMapping("/api/auth")
	public Usuario verificarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.verificarUsuario(usuario);
		
	}
	
	@GetMapping("/api/usuario/{id}")
	public List<UsuarioJoin> listarUsuarios(@PathVariable int id){
		return usuarioService.listarUsuarios(id);
	}
	
	@GetMapping("/api/usuario/buscar/{id}")
	public Usuario getUsuarioById(@PathVariable int id) {
		return usuarioService.buscarUsuarioPorId(id);
	}
	
	@PutMapping("/api/usuario/{id}")
	public Mensaje updateUsuario(@PathVariable int id,
			@RequestBody Usuario usuario) {
		return usuarioService.updateUsuario(usuario, id);
	}
	
	@DeleteMapping("/api/usuario/{id}/{estado}")
	public Mensaje borrarUsuario(@PathVariable int id, @PathVariable int estado) {
		return usuarioService.borrarUsuario(id, estado);
	}


}

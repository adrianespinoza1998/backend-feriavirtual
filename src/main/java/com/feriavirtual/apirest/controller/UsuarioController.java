package com.feriavirtual.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class UsuarioController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IUsuarioService usuarioSevice;
	
	@PostMapping("/api/usuario")
	public Mensaje crearUsuario(@RequestBody Usuario usuario){		
		return usuarioSevice.crearUsuario(jdbcTemplate, usuario);
	}
	
	@GetMapping("/api/usuario/{id}")
	public List<Usuario> listarUsuarios(@PathVariable int id){
		return usuarioSevice.listarUsuarios(jdbcTemplate, id);
	}
	
	@GetMapping("/api/usuario/buscar/{id}")
	public Usuario getUsuarioById(@PathVariable int id) {
		return usuarioSevice.buscarUsuarioPorId(jdbcTemplate, id);
	}
	
	@PutMapping("/api/usuario/{id}")
	public Mensaje updateUsuario(@PathVariable int id,
			@RequestBody Usuario usuario) {
		return usuarioSevice.updateUsuario(jdbcTemplate, usuario, id);
	}
	
	@DeleteMapping("/api/usuario/{id}")
	public Mensaje borrarUsuario(@PathVariable int id) {
		return usuarioSevice.borrarUsuario(jdbcTemplate, id);
	}

}

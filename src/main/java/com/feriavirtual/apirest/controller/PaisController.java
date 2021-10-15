package com.feriavirtual.apirest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Pais;
import com.feriavirtual.apirest.service.IPaisService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PaisController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IPaisService paisService;
	
	@PostMapping("/api/pais")
	public Mensaje crearPais(@RequestBody Pais pais){		
		return paisService.crearPais(jdbcTemplate, pais);		
	}
	
	@GetMapping("/api/pais")
	public List<Pais> listarPais(){
		return paisService.listarPais(jdbcTemplate);
	}
	
	@GetMapping("/api/pais/{id}")
	public Pais getPaisById(@PathVariable int id) {
		return paisService.getPaisById(jdbcTemplate, id);
	}
	
	@PutMapping("/api/pais/{id}")
	public Mensaje updatePais(@PathVariable int id,
			@RequestBody Pais pais) {
		return paisService.updatePais(jdbcTemplate, id, pais);
	}
	
	@DeleteMapping("/api/pais/{id}")
	public Mensaje borrarPais(@PathVariable int id) {
		return paisService.borrarPais(jdbcTemplate, id);
	}

}
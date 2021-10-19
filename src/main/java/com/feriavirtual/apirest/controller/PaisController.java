package com.feriavirtual.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	private IPaisService paisService;
	
	@PostMapping("/api/pais")
	public Mensaje crearPais(@RequestBody Pais pais){		
		return paisService.crearPais(pais);
	}
	
	@GetMapping("/api/pais")
	public List<Pais> listarPais(){
		return paisService.listarPais();
	}
	
	@GetMapping("/api/pais/{id}")
	public Pais getPaisById(@PathVariable int id) {
		return paisService.getPaisById(id);
	}
	
	@PutMapping("/api/pais/{id}")
	public Mensaje updatePais(@PathVariable int id,
			@RequestBody Pais pais) {
		return paisService.updatePais(id, pais);
	}
	
	@DeleteMapping("/api/pais/{id}")
	public Mensaje borrarPais(@PathVariable int id) {
		return paisService.borrarPais(id);
	}

}
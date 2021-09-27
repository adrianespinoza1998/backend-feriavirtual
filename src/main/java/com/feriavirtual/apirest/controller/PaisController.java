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
import com.feriavirtual.apirest.models.Pais;
import com.feriavirtual.apirest.dbo.PaisDBO;

@RestController
public class PaisController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private PaisDBO objPaisDBO = new PaisDBO();
	
	@PostMapping("/api/pais")
	public Mensaje getPais(@RequestBody Pais pais){
		
		objPaisDBO.setJdbcTemplate(jdbcTemplate);
		
		Mensaje mensaje = new Mensaje();
		
		try {
			
			if(!pais.getDescripcion().equals("")) {
				int crearPais = objPaisDBO.crearPais(pais.getDescripcion());
				
				if(crearPais == 1) {
					
					mensaje.setMsg("Pais " + pais.getDescripcion() + " creado de forma correcta");
					
					return mensaje;
					
				}
				
				mensaje.setMsg("No se creo el pais " + pais.getDescripcion());
			}else {
				 mensaje.setMsg("Pais vacío");
				 
				 return mensaje;
			}
			
			return mensaje;
		}catch (Exception e) {
			mensaje.setMsg(e.getMessage());
			
			return mensaje;
		}
	}
	
	@GetMapping("/api/pais")
	public List<Pais> listarPais(){
		
		objPaisDBO.setJdbcTemplate(jdbcTemplate);
		
		return objPaisDBO.listarPaises();
		
	}
	
	@GetMapping("/api/pais/{id}")
	public Pais getPaisById(@PathVariable int id) {
		objPaisDBO.setJdbcTemplate(jdbcTemplate);
		
		return objPaisDBO.buscarPaisPorId(id);

	}
	
	@PutMapping("/api/pais/{id}")
	public Mensaje updatePais(@PathVariable int id,
			@RequestBody Pais pais) {
		objPaisDBO.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();
		
		try {
			int editarPais = objPaisDBO.editarPais(id, pais.getDescripcion());
			
			if(editarPais == 1) {
				
				objMensaje.setMsg("País " + pais.getDescripcion() + " editado");
				
				return objMensaje;
				
			}
			
			objMensaje.setMsg("No se pudo editar el país" + pais.getDescripcion());
			
			return objMensaje;
			
		}catch (Exception e) {
			objMensaje.setMsg(e.getMessage());
			
			return objMensaje;
		}

	}
	
	@DeleteMapping("/api/pais/{id}")
	public Mensaje borrarPais(@PathVariable int id) {
		
		objPaisDBO.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();
		
		try {
			
			int deletePais = objPaisDBO.borrarPais(id);
			
			if(deletePais == 1) {
				
				objMensaje.setMsg("País con el id: " + id + " borrado");
				
				return objMensaje;
				
			}else {
				
				objMensaje.setMsg("No se pudo borrar el país con el id: " + id);
				return objMensaje;
			}
			
		}catch (Exception e) {
			objMensaje.setMsg(e.getMessage());
			
			return objMensaje;
		}
	}

}
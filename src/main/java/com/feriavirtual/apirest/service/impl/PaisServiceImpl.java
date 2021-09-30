package com.feriavirtual.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Pais;
import com.feriavirtual.apirest.repository.IPaisRepository;
import com.feriavirtual.apirest.service.IPaisService;

@Service
@Configurable
public class PaisServiceImpl implements IPaisService {
	
	@Autowired
	private IPaisRepository paisRepository;
	
	public PaisServiceImpl() {
		
	}

	@Override
	public Mensaje crearPais(JdbcTemplate jdbcTemplate, Pais pais) {

		paisRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje mensaje = new Mensaje();
		
		try {
			
			if(!pais.getDescripcion().equals("")) {

				int crearPais = paisRepository.crearPais(pais.getDescripcion());
				
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

	@Override
	public List<Pais> listarPais(JdbcTemplate jdbcTemplate) {
		paisRepository.setJdbcTemplate(jdbcTemplate);
		
		return paisRepository.listarPaises();
	}

	@Override
	public Pais getPaisById(JdbcTemplate jdbcTemplate, int id) {
		paisRepository.setJdbcTemplate(jdbcTemplate);
		
		return paisRepository.buscarPaisPorId(id);
	}

	@Override
	public Mensaje updatePais(JdbcTemplate jdbcTemplate, int id, Pais pais) {
		
		paisRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();
		
		try {
			int editarPais = paisRepository.editarPais(id, pais.getDescripcion());
			
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

	@Override
	public Mensaje borrarPais(JdbcTemplate jdbcTemplate, int id) {
		
		paisRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();
		
		try {
			
			int deletePais = paisRepository.borrarPais(id);
			
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

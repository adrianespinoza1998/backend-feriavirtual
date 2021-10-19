package com.feriavirtual.apirest.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PaisServiceImpl() {
		
	}

	@Override
	public Mensaje crearPais(Pais pais) {

		paisRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje mensaje = new Mensaje();

		try{
			Map crearPais = paisRepository.crearPais(pais.getDescripcion().toUpperCase());

			BigDecimal verfCrearPais = (BigDecimal) crearPais.get("OUT_ESTADO");

			if(verfCrearPais.intValue() == 0){
				mensaje.setMsg("Pais " + pais.getDescripcion() + " creado de forma correcta");

				return mensaje;
			}

			mensaje.setMsg("No se creo el pais " + pais.getDescripcion());

			return mensaje;
		}catch (Exception e){
			mensaje.setMsg(e.getMessage());

			return mensaje;
		}
	}

	@Override
	public List<Pais> listarPais() {
		paisRepository.setJdbcTemplate(jdbcTemplate);
		
		return paisRepository.listarPaises();
	}

	@Override
	public Pais getPaisById(int id) {
		paisRepository.setJdbcTemplate(jdbcTemplate);
		
		return paisRepository.buscarPaisPorId(id);
	}

	@Override
	public Mensaje updatePais(int id, Pais pais) {
		
		paisRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();

		try{
			Map editarPais = paisRepository.editarPais(id, pais.getDescripcion().toUpperCase());

			BigDecimal verfEditarPais = (BigDecimal) editarPais.get("OUT_ESTADO");

			if(verfEditarPais.intValue() == 0){
				objMensaje.setMsg("País " + pais.getDescripcion() + " editado");

				return objMensaje;
			}

			objMensaje.setMsg("No se pudo editar el país" + pais.getDescripcion());

			return objMensaje;
		}catch (Exception e){
			objMensaje.setMsg(e.getMessage());

			return objMensaje;
		}
	}

	@Override
	public Mensaje borrarPais(int id) {
		
		paisRepository.setJdbcTemplate(jdbcTemplate);
		
		Mensaje objMensaje = new Mensaje();

		try{
			Map borrarPais = paisRepository.borrarPais(id);

			BigDecimal verfBorrarPais = (BigDecimal) borrarPais.get("OUT_ESTADO");

			if(verfBorrarPais.intValue() == 0){
				objMensaje.setMsg("País con el id: " + id + " borrado");

				return objMensaje;
			}else{
				objMensaje.setMsg("No se pudo borrar el país con el id: " + id);
				return objMensaje;
			}
		}catch (Exception e){
			objMensaje.setMsg(e.getMessage());

			return objMensaje;
		}
	}

}

package com.feriavirtual.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Subastas;
import com.feriavirtual.apirest.repository.ISubastasRepository;
import com.feriavirtual.apirest.service.ISubastasService;

@Configurable
@Service
@EnableAutoConfiguration
public class SubastasServiceImpl implements ISubastasService {

    @Autowired
    private ISubastasRepository subastasRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mensaje crearSubastas(Subastas subastas) {
        subastasRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean crearSubasta = subastasRepository.crearSubasta(subastas.getIdUsuario(),
                    subastas.getIdSolicitudProductos());

            if(crearSubasta){
                mensaje.setMsg("Subasta con el id usuario: " + subastas.getIdUsuario() +
                        " creado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se creo la subasta con el id usuario:  " +
                    subastas.getIdUsuario());

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public List<Subastas> listarSubastas(int id) {
        subastasRepository.setJdbcTemplate(jdbcTemplate);

        return subastasRepository.listarSubastas(id);
    }

    @Override
    public Subastas getSubastaXId(int id) {
        subastasRepository.setJdbcTemplate(jdbcTemplate);

        return subastasRepository.buscarSubastaXId(id);
    }

    @Override
    public Mensaje updateSubasta(int id, Subastas subastas) {
        subastasRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean editarSubasta = subastasRepository.editarSubasta(id, subastas.getIdUsuario(),
                    subastas.getIdSolicitudProductos());

            if(editarSubasta){
                mensaje.setMsg("Subasta con el id: " + id + " editado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo editar la subasta con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public Mensaje borrarSubasta(int id) {
        subastasRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try {
            boolean borrarSubasta = subastasRepository.borrarSubasta(id);

            if(borrarSubasta){
                mensaje.setMsg("Subasta con el id: " + id + " borrado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo borrar la subasta con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }
}

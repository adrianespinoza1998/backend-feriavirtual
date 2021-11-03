package com.feriavirtual.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feriavirtual.apirest.models.Ciudad;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.repository.ICiudadRepository;
import com.feriavirtual.apirest.service.ICiudadService;

@Configurable
@Service
@EnableAutoConfiguration
public class CiudadServiceImpl implements ICiudadService {

    @Autowired
    private ICiudadRepository ciudadRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mensaje crearCiudad(Ciudad ciudad) {

        ciudadRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try {
            if (ciudad.getDescripcion() != null && !ciudad.getDescripcion().equals("") &&
                    ciudad.getIdPais() != 0) {

                boolean crearCiudad = ciudadRepository.crearCiudad(ciudad.getDescripcion().toUpperCase(),
                        ciudad.getIdPais());

                if (crearCiudad) {
                    mensaje.setMsg("Ciudad " + ciudad.getDescripcion()
                            + " creado de forma correcta");
                } else {
                    mensaje.setMsg("Ciudad " + ciudad.getDescripcion() +
                            " no se pudo crear");
                }
            } else {
                mensaje.setMsg("Uno o más campos vacíos");
            }

            return mensaje;
        } catch (Exception e) {
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public List<Ciudad> listarCiudades(int idPais) {
        ciudadRepository.setJdbcTemplate(jdbcTemplate);
        return ciudadRepository.listarCiudades(idPais);
    }

    @Override
    public Ciudad buscarCiudadXId(int idCiudad) {
        ciudadRepository.setJdbcTemplate(jdbcTemplate);
        return ciudadRepository.getCiudadById(idCiudad);
    }

    @Override
    public Mensaje updateCiudad(int idCiudad, Ciudad ciudad) {

        ciudadRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try {
            if (ciudad.getDescripcion() != null && !ciudad.getDescripcion().equals("") &&
                    ciudad.getIdPais() != 0) {

                boolean updateCiudad = ciudadRepository.editarCiudad(idCiudad, ciudad.getDescripcion().toUpperCase(),
                        ciudad.getIdPais());

                if(updateCiudad){
                    mensaje.setMsg("Ciudad " + ciudad.getDescripcion()
                            + " editada de forma correcta");
                }else{
                    mensaje.setMsg("Ciudad "+ ciudad.getDescripcion() +
                            " no se pudo editar");
                }
            }else{
                mensaje.setMsg("Uno o más campos vacíos");
            }

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());

            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public Mensaje borrarCiudad(int idCiudad) {
        ciudadRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try {
            boolean deleteCiudad = ciudadRepository.borrarCiudad(idCiudad);

            if(deleteCiudad){
                mensaje.setMsg("Ciudad con el id " + idCiudad
                        + " editada de forma correcta");
            }else{
                mensaje.setMsg("Ciudad con el id "+ idCiudad +
                        " no se pudo editar");
            }

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());

            e.printStackTrace();

            return mensaje;
        }
    }
}

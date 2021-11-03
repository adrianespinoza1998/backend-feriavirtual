package com.feriavirtual.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.TipoTransporte;
import com.feriavirtual.apirest.repository.ITipoTransporteRepository;
import com.feriavirtual.apirest.service.ITipoTransporteService;

@Configurable
@Service
@EnableAutoConfiguration
public class TipoTransporteServiceImpl implements ITipoTransporteService {

    @Autowired
    private ITipoTransporteRepository tipoTransporteRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mensaje crearTipoTransporte(TipoTransporte tipoTransporte) {
        tipoTransporteRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try {
            boolean crearTipoTran = tipoTransporteRepository.crearTipoTransporte(tipoTransporte.getDescripcion().toUpperCase());

            if(crearTipoTran){
                mensaje.setMsg("Tipo transporte " + tipoTransporte.getDescripcion() + " creado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se creo el tipo transporte " + tipoTransporte.getDescripcion());

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public List<TipoTransporte> listarTipoTransporte() {
        tipoTransporteRepository.setJdbcTemplate(jdbcTemplate);
        return tipoTransporteRepository.listarTipoTransporte();
    }

    @Override
    public TipoTransporte getTipoTransporteXId(int id) {
        tipoTransporteRepository.setJdbcTemplate(jdbcTemplate);
        return tipoTransporteRepository.buscarTipoTansportePorId(id);
    }

    @Override
    public Mensaje updateTipoTransporte(int id, TipoTransporte tipoTransporte) {
        tipoTransporteRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try {
            boolean updateTipoTran = tipoTransporteRepository.editarTipoTansporte(id, tipoTransporte.getDescripcion().toUpperCase());

            if(updateTipoTran){
                mensaje.setMsg("Tipo transporte " + tipoTransporte.getDescripcion() + " editado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se edito el tipo transporte " + tipoTransporte.getDescripcion());

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public Mensaje borrarTipoTransporte(int id) {
        tipoTransporteRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try {
            boolean deleteTipoTran = tipoTransporteRepository.borrarTipoTansporte(id);

            if(deleteTipoTran){
                mensaje.setMsg("Tipo transporte con el id: " + id + " borrado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se borro el tipo transporte con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }
}

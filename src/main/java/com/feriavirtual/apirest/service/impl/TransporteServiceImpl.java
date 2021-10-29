package com.feriavirtual.apirest.service.impl;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Transportes;
import com.feriavirtual.apirest.repository.ITransporteRepository;
import com.feriavirtual.apirest.service.ITransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Configurable
@Service
@EnableAutoConfiguration
public class TransporteServiceImpl  implements ITransporteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ITransporteRepository transporteRepository;

    @Override
    public Mensaje crearTransporte(Transportes transportes) {
        transporteRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean crearTran = transporteRepository.crearTransporte(transportes.getIdTipoTransporte(),
                    transportes.getMarca().toUpperCase(), transportes.getCapacidad(), transportes.getPeso(),
                    transportes.getIdUsuario());

            if(crearTran){
                mensaje.setMsg("Transporte de marca " + transportes.getMarca() + " creado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se creo el transporte de marca " + transportes.getMarca());

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public List<Transportes> listarTransportes() {
        transporteRepository.setJdbcTemplate(jdbcTemplate);
        return transporteRepository.listarTransportes();
    }

    @Override
    public List<Transportes> listarTransportesXUser(int id) {
        transporteRepository.setJdbcTemplate(jdbcTemplate);
        return transporteRepository.listarTransportesXUsuario(id);
    }

    @Override
    public Transportes buscarTransporteXId(int id) {
        transporteRepository.setJdbcTemplate(jdbcTemplate);
        return transporteRepository.buscarTransporteXId(id);
    }

    @Override
    public Mensaje editarTransporte(int id, Transportes transportes) {
        transporteRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean updateTran = transporteRepository.editarTransporte(id, transportes.getIdTipoTransporte(),
                    transportes.getMarca().toUpperCase(), transportes.getCapacidad(), transportes.getPeso(),
                    transportes.getIdUsuario());

            if(updateTran){
                mensaje.setMsg("Transporte con el id: " + id + " editado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se edito el transporte con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public Mensaje borrarTransporte(int id) {
        transporteRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean deleteTran = transporteRepository.borrarTransporte(id);

            if(deleteTran){
                mensaje.setMsg("Transporte con el id: " + id + " borrado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se borro el transporte con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }
}

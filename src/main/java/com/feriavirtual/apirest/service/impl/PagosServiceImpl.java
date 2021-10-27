package com.feriavirtual.apirest.service.impl;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Pagos;
import com.feriavirtual.apirest.models.PagosJoin;
import com.feriavirtual.apirest.repository.IPagosRepository;
import com.feriavirtual.apirest.service.IPagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class PagosServiceImpl implements IPagosService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IPagosRepository pagosRepository;

    @Override
    public Mensaje crearPago(Pagos pagos) {
        pagosRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try {
            boolean createPago = pagosRepository.crearPago(pagos.getIdSubastas(), pagos.getMonto(),
                    pagos.getTarjeta(), pagos.getIdMoneda());

            if(createPago){
                mensaje.setMsg("Pago con el id subasta: " + pagos.getIdSubastas() +
                        " creado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se creo el pago con el id subasta: " + pagos.getIdSubastas());

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public List<PagosJoin> listarPagos() {
        pagosRepository.setJdbcTemplate(jdbcTemplate);
        return pagosRepository.listarPagos();
    }

    @Override
    public List<PagosJoin> listarPagosXUsuario(int id) {
        pagosRepository.setJdbcTemplate(jdbcTemplate);
        return pagosRepository.listarPagosXUsuario(id);
    }

    @Override
    public List<PagosJoin> listarPagosXIdSolicitud(int id) {
        pagosRepository.setJdbcTemplate(jdbcTemplate);
        return pagosRepository.listarPagosXIdSolicitud(id);
    }

    @Override
    public Pagos getPagoXId(int id) {
        pagosRepository.setJdbcTemplate(jdbcTemplate);
        return pagosRepository.getPagoXId(id);
    }

    @Override
    public Mensaje editarPago(int id, Pagos pagos) {
        pagosRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean updatePago = pagosRepository.editarPago(id, pagos.getIdSubastas(), pagos.getMonto(),
                    pagos.getTarjeta(), pagos.getIdMoneda());

            if(updatePago){
                mensaje.setMsg("Pago con el id: " + id + " editado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo editar el pago con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public Mensaje eliminarPago(int id) {
        pagosRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean deletePago = pagosRepository.eliminarPago(id);

            if(deletePago){
                mensaje.setMsg("Pago con el id: " + id + " borrado");

                return mensaje;
            }else{
                mensaje.setMsg("No se pudo borrar el pago con el id: " + id);
                return mensaje;
            }
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }
}

package com.feriavirtual.apirest.service.impl;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.SolicitudProductos;
import com.feriavirtual.apirest.repository.ISolicitudProductosRepository;
import com.feriavirtual.apirest.service.ISolicitudProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Configurable
@Service
@EnableAutoConfiguration
public class SolicitudProductosServiceImpl implements ISolicitudProductosService {

    @Autowired
    private ISolicitudProductosRepository solicitudProductosRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mensaje crearSolicitudProducto(SolicitudProductos objSolProd) {
        solicitudProductosRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean crearSolProd = solicitudProductosRepository.crearSolicitudProducto(
                    objSolProd.getIdUsuario(), objSolProd.getIdTipoSolicitud(), objSolProd.getIdEstadoSolicitud());

            if(crearSolProd){
                mensaje.setMsg("Solicitud producto con el id tipo solicitud: " + objSolProd.getIdTipoSolicitud() +
                        " creado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se creo la solicitud producto con el id tipo solicitud:  " +
                    objSolProd.getIdTipoSolicitud());

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public List<SolicitudProductos> listarSolicitudProductos(int idEstadoSolicitud) {
        solicitudProductosRepository.setJdbcTemplate(jdbcTemplate);

        return solicitudProductosRepository.listarSolicitudProductos(idEstadoSolicitud);
    }

    @Override
    public List<SolicitudProductos> listarSolicitudProductosXUser(int id) {
        solicitudProductosRepository.setJdbcTemplate(jdbcTemplate);

        return solicitudProductosRepository.listarSolicitudProductosXUser(id);
    }

    @Override
    public SolicitudProductos buscarSolicitudProductoXId(int id) {
        solicitudProductosRepository.setJdbcTemplate(jdbcTemplate);

        return solicitudProductosRepository.buscarSolicitudProductoXId(id);
    }

    @Override
    public Mensaje editarSolicitudProducto(int id, SolicitudProductos objSolProd) {
        solicitudProductosRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean editarSolProd = solicitudProductosRepository.editarSolicitudProducto(id, objSolProd.getIdUsuario(),
                    objSolProd.getIdTipoSolicitud(), objSolProd.getIdEstadoSolicitud());

            if(editarSolProd){
                mensaje.setMsg("Solicitud producto con el id: " + id +
                        " editado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo editar la solicitud producto con el id: " +
                    id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public Mensaje borrarSolicitudProducto(int id) {
        solicitudProductosRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try {
            boolean borrarSolProd = solicitudProductosRepository.eliminarSolicitudProducto(id);

            if(borrarSolProd){
                mensaje.setMsg("Solicitud producto con el id: " + id + " borrado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo borrar la solicitud producto con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }
}

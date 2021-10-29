package com.feriavirtual.apirest.service.impl;

import com.feriavirtual.apirest.models.DetalleSolProductos;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.repository.IDetSolProdRepository;
import com.feriavirtual.apirest.service.IDetSolProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Configurable
@Service
@EnableAutoConfiguration
public class DetSolProdServiceImpl implements IDetSolProdService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IDetSolProdRepository detSolProdRepository;

    @Override
    public Mensaje crearDetSolProd(DetalleSolProductos detSolProd) {
        detSolProdRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean createDetSolProd = detSolProdRepository.crearDetSolProd(detSolProd.getIdProducto(),
                    detSolProd.getIdSolicitudProductos(), detSolProd.getCantidad());

            if(createDetSolProd){
                mensaje.setMsg("Detalle solicitud con el id solicitud: " + detSolProd.getIdSolicitudProductos() +
                        " creado de forma correcta");

            }else{
                mensaje.setMsg("Detalle solicitud con el id solicitud: "+ detSolProd.getIdSolicitudProductos() +
                        " no se pudo crear");
            }

            return mensaje;

        }catch (Exception e){
            mensaje.setMsg(e.getMessage());

            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public List<DetalleSolProductos> listarDetSolProd() {
        detSolProdRepository.setJdbcTemplate(jdbcTemplate);
        return detSolProdRepository.listarDetSolProd();
    }

    @Override
    public DetalleSolProductos getDetSolProdXSol(int id) {
        detSolProdRepository.setJdbcTemplate(jdbcTemplate);
        return detSolProdRepository.getDetSolProdXSol(id);
    }

    @Override
    public DetalleSolProductos getDetSolProdXId(int id) {
        detSolProdRepository.setJdbcTemplate(jdbcTemplate);
        return detSolProdRepository.getDetSolProdXId(id);
    }

    @Override
    public Mensaje editarDetSolProd(int id, DetalleSolProductos detSolProd) {
        detSolProdRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean updateDetSolProd = detSolProdRepository.editarDetSolProd(id, detSolProd.getIdProducto(),
                    detSolProd.getIdSolicitudProductos(), detSolProd.getCantidad());

            if(updateDetSolProd){
                mensaje.setMsg("Detalle solicitud con el id: " + id + " editado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo editar el detalle solicitud con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());

            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public Mensaje borrarDetSolProd(int id) {
        detSolProdRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean deleteDetSolProd = detSolProdRepository.eliminarDetSolProd(id);

            if(deleteDetSolProd){
                mensaje.setMsg("Detalle solicitud con el id: " + id + " borrado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo borrar el detalle solicitud con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());

            e.printStackTrace();

            return mensaje;
        }
    }
}

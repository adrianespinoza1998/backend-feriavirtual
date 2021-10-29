package com.feriavirtual.apirest.service.impl;

import com.feriavirtual.apirest.models.DetalleVenta;
import com.feriavirtual.apirest.models.DetalleVentaJoin;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.repository.IDetVentaRepository;
import com.feriavirtual.apirest.service.IDetVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Configurable
@Service
@EnableAutoConfiguration
public class DetVentaServiceImpl implements IDetVentaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IDetVentaRepository detVentaRepository;

    @Override
    public Mensaje crearDetVenta(DetalleVenta objDetVenta) {
        detVentaRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean createDetVenta = detVentaRepository.crearDetVenta(objDetVenta.getIdProducto(),
                    objDetVenta.getCantidad(), objDetVenta.getPrecio());

            if(createDetVenta){
                mensaje.setMsg("Detalle venta con el id producto: " + objDetVenta.getIdProducto() +
                        " creado de forma correcta");

            }else{
                mensaje.setMsg("Detalle venta con el id producto: "+ objDetVenta.getIdProducto() +
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
    public List<DetalleVentaJoin> listarDetalleVenta() {
        detVentaRepository.setJdbcTemplate(jdbcTemplate);
        return detVentaRepository.listarDetVenta();
    }

    @Override
    public DetalleVentaJoin buscarDetVentaXId(int id) {
        detVentaRepository.setJdbcTemplate(jdbcTemplate);
        return detVentaRepository.buscarDetVentaXId(id);
    }

    @Override
    public Mensaje updateDetVenta(int id, DetalleVenta objDetVenta) {
        detVentaRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean editarDetVenta = detVentaRepository.editarDetVenta(id, objDetVenta.getIdProducto(),
                    objDetVenta.getCantidad(), objDetVenta.getPrecio());

            if(editarDetVenta){
                mensaje.setMsg("Detalle venta con el id: " + id + " editado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo editar el detalle venta con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }

    }

    @Override
    public Mensaje deleteDetVenta(int id) {
        detVentaRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean borrarDetVenta = detVentaRepository.eliminarDetVenta(id);

            if(borrarDetVenta){
                mensaje.setMsg("Detalle venta con el id: " + id + " borrado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo borrar el Detalle venta con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }
}

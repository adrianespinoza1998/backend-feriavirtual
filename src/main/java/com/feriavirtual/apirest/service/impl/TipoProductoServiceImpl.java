package com.feriavirtual.apirest.service.impl;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.TipoProducto;
import com.feriavirtual.apirest.repository.ITipoProductoRepository;
import com.feriavirtual.apirest.service.ITipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Configurable
@Service
@EnableAutoConfiguration
public class TipoProductoServiceImpl implements ITipoProductoService {

    @Autowired
    private ITipoProductoRepository tipoProductoRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mensaje crearTipoProducto(TipoProducto tipoProducto) {

        tipoProductoRepository.setJdbcTemplate(jdbcTemplate);
        Mensaje mensaje = new Mensaje();

        try{

            boolean crearTipoProducto = tipoProductoRepository
                    .crearTipoProducto(tipoProducto.getDescripcion().toUpperCase());

            if(crearTipoProducto){
                mensaje.setMsg("Tipo producto " +tipoProducto.getDescripcion()+" creado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se creo el tipo producto " + tipoProducto.getDescripcion());

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public List<TipoProducto> listarTipoProducto() {
        tipoProductoRepository.setJdbcTemplate(jdbcTemplate);

        return tipoProductoRepository.listarTipoProducto();
    }

    @Override
    public TipoProducto getTipoProductoXId(int id) {
        tipoProductoRepository.setJdbcTemplate(jdbcTemplate);

        return tipoProductoRepository.buscarTipoProductoXId(id);
    }

    @Override
    public Mensaje updateTipoProducto(int id, TipoProducto tipoProducto) {
        tipoProductoRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();
        try{

            boolean editarTipoProducto = tipoProductoRepository
                    .editarTipoProducto(id, tipoProducto.getDescripcion().toUpperCase());

            if(editarTipoProducto){
                mensaje.setMsg("Tipo producto " + tipoProducto.getDescripcion() +
                        " editado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("Tipo producto " + tipoProducto.getDescripcion() + " no se pudo editar");

            return mensaje;

        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public Mensaje borrarTipoProducto(int id) {
        tipoProductoRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean borrarTipoProducto = tipoProductoRepository.borrarTipoProducto(id);

            if(borrarTipoProducto){
                mensaje.setMsg("Tipo producto con el id: " + id + " borrado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo borrar el tipo producto con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }
}

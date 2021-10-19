package com.feriavirtual.apirest.service.impl;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Moneda;
import com.feriavirtual.apirest.repository.IMonedaRepository;
import com.feriavirtual.apirest.service.IMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
@Configurable
public class MonedaServiceImpl implements IMonedaService {

    @Autowired
    private IMonedaRepository monedaRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mensaje crearMoneda(Moneda moneda) {
        monedaRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            if(moneda.getSigla()!=null && !moneda.getSigla().equals("")
                    && moneda.getDescripcion()!=null && !moneda.getDescripcion().equals("")){

                Map crearMoneda = monedaRepository.crearMoneda(moneda.getDescripcion().toUpperCase(),
                        moneda.getSigla().toUpperCase());

                BigDecimal verfCrearMoneda = (BigDecimal) crearMoneda.get("OUT_ESTADO");

                if(verfCrearMoneda.intValue()==0){
                    mensaje.setMsg("Moneda " + moneda.getDescripcion()
                            + " creado de forma correcta");
                }else{
                    mensaje.setMsg("Moneda "+ moneda.getDescripcion() +
                            " no se pudo crear");
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
    public List<Moneda> listarMonedas() {
        monedaRepository.setJdbcTemplate(jdbcTemplate);
        return monedaRepository.listarMonedas();
    }

    @Override
    public Moneda buscarMonedaXId(int idMoneda) {
        monedaRepository.setJdbcTemplate(jdbcTemplate);
        return monedaRepository.getMonedaById(idMoneda);
    }

    @Override
    public Mensaje updateMoneda(int idMoneda, Moneda moneda) {
        monedaRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            if(moneda.getSigla()!=null && !moneda.getSigla().equals("")
                    && moneda.getDescripcion()!=null && !moneda.getDescripcion().equals("")){

                Map updateMoneda = monedaRepository.editarMoneda(idMoneda,moneda.getDescripcion().toUpperCase(),
                        moneda.getSigla().toUpperCase());

                BigDecimal verfUpdateMoneda = (BigDecimal) updateMoneda.get("OUT_ESTADO");

                if(verfUpdateMoneda.intValue()==0){
                    mensaje.setMsg("Moneda " + moneda.getDescripcion()
                            + " editada de forma correcta");
                }else{
                    mensaje.setMsg("Moneda "+ moneda.getDescripcion() +
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
    public Mensaje borrarMoneda(int idMoneda) {
        monedaRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            Map borrarMoneda = monedaRepository.borrarMoneda(idMoneda);

            BigDecimal verfBorrarMoneda = (BigDecimal) borrarMoneda.get("OUT_ESTADO");

            if(verfBorrarMoneda.intValue()==0){
                mensaje.setMsg("Moneda con el id: " + idMoneda
                        + " borrada de forma correcta");
            }else{
                mensaje.setMsg("Moneda con el id: "+ idMoneda +
                        " no se pudo borrar");
            }

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());

            e.printStackTrace();

            return mensaje;
        }
    }
}

package com.feriavirtual.apirest.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feriavirtual.apirest.models.Contrato;
import com.feriavirtual.apirest.models.ContratoJoin;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.repository.IContratoRepository;
import com.feriavirtual.apirest.service.IContratoService;

@Configurable
@Service
@EnableAutoConfiguration
public class ContratoServiceImpl implements IContratoService {

    @Autowired
    private IContratoRepository contratoRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mensaje crearContrato(Contrato contrato) {
        contratoRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            if(contrato.getIdUsuario()!=0 && contrato.getFirmado()!=0) {

                Date fechaIni = addDays(contrato.getFechaIni(), 1);
                Date fechaFin = addDays(contrato.getFechaFin(),1);

                boolean crearContrato = contratoRepository.crearContrato(contrato.getFirmado(),
                        contrato.getIdUsuario(),contrato.getCodigo(),fechaIni, fechaFin);

                if(crearContrato){
                    mensaje.setMsg("Contrato con el usuario con el id: " + contrato.getIdUsuario() + " creado de forma correcta");

                }else{
                    mensaje.setMsg("Contrato del usuario con el id: "+ contrato.getIdUsuario() + " no se pudo crear");
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
    public List<ContratoJoin> listarContratos(int firmado) {
        contratoRepository.setJdbcTemplate(jdbcTemplate);
        return contratoRepository.listarContratos(firmado);
    }

    @Override
    public List<ContratoJoin> listarContratosXUsuario(int idUsuario, int firmado) {
        contratoRepository.setJdbcTemplate(jdbcTemplate);
        return contratoRepository.listarContratosXUsuario(idUsuario,firmado);
    }

    @Override
    public Contrato buscarContratoPorId(int id) {
        contratoRepository.setJdbcTemplate(jdbcTemplate);
        return contratoRepository.getContrato(id);
    }

    @Override
    public Mensaje updateContrato(Contrato contrato, int id) {
        contratoRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje objMensaje = new Mensaje();

        try {
            Date fechaIni = addDays(contrato.getFechaIni(), 1);
            Date fechaFin = addDays(contrato.getFechaFin(),1);

            boolean updateContrato = contratoRepository.editarContrato(id, contrato.getFirmado(),
                    contrato.getIdUsuario(), contrato.getCodigo().toUpperCase(), fechaIni,
                    fechaFin);

            if (updateContrato) {
                objMensaje.setMsg("Contrato con el id: " + id + " actualizado");
            } else {
                objMensaje.setMsg("No se pudo actaulizar el contrato con el id: " + id);
            }

            return objMensaje;

        } catch (Exception e) {
            objMensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return objMensaje;
        }
    }


    @Override
    public Mensaje borrarContrato(int id) {
        contratoRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje objMensaje = new Mensaje();

        try {

            boolean deleteContrato = contratoRepository.borrarContrato(id);

            if(deleteContrato){
                objMensaje.setMsg("Contrato con el id: " + id + " borrado");
            }else{
                objMensaje.setMsg("No se pudo borrar el contrato con el id: " + id);
            }
            return objMensaje;

        }catch (Exception e){
            objMensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return objMensaje;
        }

    }

    private Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}

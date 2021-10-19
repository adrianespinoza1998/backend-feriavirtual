package com.feriavirtual.apirest.service.impl;

import com.feriavirtual.apirest.models.Contrato;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.repository.IContratoRepository;
import com.feriavirtual.apirest.service.IContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
@Configurable
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

                Map crearContrato = contratoRepository.crearContrato(contrato.getFirmado(),
                        contrato.getIdUsuario());

                BigDecimal verfCrearContrato = (BigDecimal) crearContrato.get("OUT_ESTADO");

                if(verfCrearContrato.intValue()==0){
                    mensaje.setMsg("Contrato con de el usuario con el id: " + contrato.getIdUsuario() + " creado de forma correcta");

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
    public List<Contrato> listarContratos(int firmado) {
        contratoRepository.setJdbcTemplate(jdbcTemplate);
        return contratoRepository.listarContratos(firmado);
    }

    @Override
    public List<Contrato> listarContratosXUsuario(int idUsuario, int firmado) {
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
            Map updateContrato = contratoRepository.editarContrato(id, contrato.getFirmado(),
                    contrato.getIdUsuario());

            BigDecimal verfUpdateContrato = (BigDecimal) updateContrato.get("OUT_ESTADO");

            if (verfUpdateContrato.intValue() == 0) {
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

            Map deleteContrato = contratoRepository.borrarContrato(id);

            BigDecimal verfDeleteContrato = (BigDecimal) deleteContrato.get("OUT_ESTADO");

            if(verfDeleteContrato.intValue() == 0){
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
}

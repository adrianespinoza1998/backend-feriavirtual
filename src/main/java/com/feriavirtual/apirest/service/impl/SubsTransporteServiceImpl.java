package com.feriavirtual.apirest.service.impl;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.SubastasTransportes;
import com.feriavirtual.apirest.repository.ISubsTransporteRepository;
import com.feriavirtual.apirest.service.ISubsTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class SubsTransporteServiceImpl implements ISubsTransporteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ISubsTransporteRepository subsTransporteRepository;

    @Override
    public Mensaje crearSubsTransporte(SubastasTransportes objSubsTran) {
        subsTransporteRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean crearSubsTran = subsTransporteRepository.crearSubsTransporte(objSubsTran.getIdSubastas(),
                    objSubsTran.getIdTransporte());

            if(crearSubsTran){
                mensaje.setMsg("Subasta transporte con el id subasta: " + objSubsTran.getIdSubastas() +
                        " creado de forma correcta");

                return mensaje;
            }

            mensaje.setMsg("No se creo la subasta transporte con el id subasta:  " +
                    objSubsTran.getIdSubastas());

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public List<SubastasTransportes> listarSubsTransporte() {
        subsTransporteRepository.setJdbcTemplate(jdbcTemplate);
        return subsTransporteRepository.listarSubsTransporte();
    }

    @Override
    public List<SubastasTransportes> listarSubsTranXIdTr(int id) {
        subsTransporteRepository.setJdbcTemplate(jdbcTemplate);
        return subsTransporteRepository.listarSubsTranXIdTr(id);
    }

    @Override
    public SubastasTransportes buscarSubsTranXId(int id) {
        subsTransporteRepository.setJdbcTemplate(jdbcTemplate);
        return subsTransporteRepository.buscarSubsTranXId(id);
    }

    @Override
    public SubastasTransportes buscarSubsTranXIdSub(int id) {
        subsTransporteRepository.setJdbcTemplate(jdbcTemplate);
        return subsTransporteRepository.buscarSubsTranXIdSub(id);
    }

    @Override
    public Mensaje editarSubsTran(int id, SubastasTransportes objSubsTran) {
        subsTransporteRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try{
            boolean editSubsTran = subsTransporteRepository.editarSubsTran(id, objSubsTran.getIdSubastas(),
                    objSubsTran.getIdTransporte());

            if(editSubsTran){
                mensaje.setMsg("Subasta transporte con el id: " + id + " editado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo editar la subasta transporte con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }

    @Override
    public Mensaje borrarSubsTran(int id) {
        subsTransporteRepository.setJdbcTemplate(jdbcTemplate);

        Mensaje mensaje = new Mensaje();

        try {
            boolean deleteSubsTran = subsTransporteRepository.borrarSubsTran(id);

            if(deleteSubsTran){
                mensaje.setMsg("Subasta transporte con el id: " + id + " borrado");

                return mensaje;
            }

            mensaje.setMsg("No se pudo borrar la subasta transporte con el id: " + id);

            return mensaje;
        }catch (Exception e){
            mensaje.setMsg(e.getMessage());
            e.printStackTrace();

            return mensaje;
        }
    }
}

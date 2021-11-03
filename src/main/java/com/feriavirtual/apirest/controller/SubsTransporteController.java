package com.feriavirtual.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.SubastasTransportes;
import com.feriavirtual.apirest.service.ISubsTransporteService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SubsTransporteController {

    @Autowired
    private ISubsTransporteService subsTransporteService;

    @PostMapping("/api/sub-transporte")
    public Mensaje crearSubsTran(@RequestBody SubastasTransportes objSubsTran){
        return subsTransporteService.crearSubsTransporte(objSubsTran);
    }

    @GetMapping("/api/sub-transporte")
    public List<SubastasTransportes> listarSubsTran(){
        return subsTransporteService.listarSubsTransporte();
    }

    @GetMapping("/api/sub-transporte/tr/{id}")
    public List<SubastasTransportes> listarSubsTranXIdTr(@PathVariable int id){
        return subsTransporteService.listarSubsTranXIdTr(id);
    }

    @GetMapping("/api/sub-transporte/{id}")
    public SubastasTransportes getSubsTranById(@PathVariable int id) {
        return subsTransporteService.buscarSubsTranXId(id);
    }

    @GetMapping("/api/sub-transporte/sub/{id}")
    public SubastasTransportes getSubsTranByIdSub(@PathVariable int id) {
        return subsTransporteService.buscarSubsTranXIdSub(id);
    }

    @PutMapping("/api/sub-transporte/{id}")
    public Mensaje updateSubsTran(@PathVariable int id,
                                 @RequestBody SubastasTransportes objSubsTran) {
        return subsTransporteService.editarSubsTran(id, objSubsTran);
    }

    @DeleteMapping("/api/sub-transporte/{id}")
    public Mensaje borrarSubsTran(@PathVariable int id) {
        return subsTransporteService.borrarSubsTran(id);
    }
}

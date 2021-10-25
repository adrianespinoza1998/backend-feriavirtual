package com.feriavirtual.apirest.controller;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.TipoTransporte;
import com.feriavirtual.apirest.service.ITipoTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TipoTransporteController {

    @Autowired
    private ITipoTransporteService tipoTransporteService;

    @PostMapping("/api/tipo-transporte")
    public Mensaje crearTipoTransporte(@RequestBody TipoTransporte tipoTransporte){
        return tipoTransporteService.crearTipoTransporte(tipoTransporte);
    }

    @GetMapping("/api/tipo-transporte")
    public List<TipoTransporte> listarTipoTransporte (){
        return tipoTransporteService.listarTipoTransporte();
    }

    @GetMapping("/api/tipo-transporte/{id}")
    public TipoTransporte buscarTipoTransporte(@PathVariable int id){
        return tipoTransporteService.getTipoTransporteXId(id);
    }

    @PutMapping("/api/tipo-transporte/{id}")
    public Mensaje editarTipoTransporte(@PathVariable int id, @RequestBody TipoTransporte tipoTransporte){
        return tipoTransporteService.updateTipoTransporte(id, tipoTransporte);
    }

    @DeleteMapping("/api/tipo-transporte/{id}")
    public Mensaje borrarTipoTransporte(@PathVariable int id){
        return tipoTransporteService.borrarTipoTransporte(id);
    }

}

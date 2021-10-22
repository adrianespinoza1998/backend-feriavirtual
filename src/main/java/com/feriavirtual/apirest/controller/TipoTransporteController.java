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
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ITipoTransporteService tipoTransporteService;

    @PostMapping("/api/tipo-transporte")
    public Mensaje crearTipoProducto(@RequestBody TipoTransporte tipoTransporte){
        return tipoTransporteService.crearTipoTransporte(tipoTransporte);
    }

    @GetMapping("/api/tipo-transporte")
    public List<TipoTransporte> listarTipoProducto (){
        return tipoTransporteService.listarTipoTransporte();
    }

    @GetMapping("/api/tipo-transporte/{id}")
    public TipoTransporte buscarTipoProducto(@PathVariable int id){
        return tipoTransporteService.getTipoTransporteXId(id);
    }

    @PutMapping("/api/tipo-transporte/{id}")
    public Mensaje editarTipoProducto(@PathVariable int id, @RequestBody TipoTransporte tipoTransporte){
        return tipoTransporteService.updateTipoTransporte(id, tipoTransporte);
    }

    @DeleteMapping("/api/tipo-transporte/{id}")
    public Mensaje borrarTipoProducto(@PathVariable int id){
        return tipoTransporteService.borrarTipoTransporte(id);
    }

}

package com.feriavirtual.apirest.controller;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Transportes;
import com.feriavirtual.apirest.service.ITransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TransporteController {

    @Autowired
    private ITransporteService transporteService;

    @PostMapping("/api/transporte")
    public Mensaje crearTransporte(@RequestBody Transportes transportes){
        return transporteService.crearTransporte(transportes);
    }

    @GetMapping("/api/transporte")
    public List<Transportes> listarTransporte (){
        return transporteService.listarTransportes();
    }

    @GetMapping("/api/transporte/usr/{id}")
    public List<Transportes> listarTransporteXUsr (@PathVariable int id){
        return transporteService.listarTransportesXUser(id);
    }

    @GetMapping("/api/transporte/{id}")
    public Transportes buscarTransporte(@PathVariable int id){
        return transporteService.buscarTransporteXId(id);
    }

    @PutMapping("/api/transporte/{id}")
    public Mensaje editarTransporte(@PathVariable int id, @RequestBody Transportes transportes){
        return transporteService.editarTransporte(id, transportes);
    }

    @DeleteMapping("/api/transporte/{id}")
    public Mensaje borrarTransporte(@PathVariable int id){
        return transporteService.borrarTransporte(id);
    }
}

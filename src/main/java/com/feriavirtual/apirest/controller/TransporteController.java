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
import com.feriavirtual.apirest.models.Transportes;
import com.feriavirtual.apirest.service.ITransporteService;

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
    public Transportes buscarTransporteXId(@PathVariable int id){
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

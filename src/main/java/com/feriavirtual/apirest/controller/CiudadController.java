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

import com.feriavirtual.apirest.models.Ciudad;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.service.ICiudadService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CiudadController {

    @Autowired
    private ICiudadService ciudadService;

    @PostMapping("/api/ciudad")
    public Mensaje crearCiudad(@RequestBody Ciudad ciudad){
        return ciudadService.crearCiudad(ciudad);
    }

    @GetMapping("/api/ciudad/{id}")
    public List<Ciudad> listarCiudad(@PathVariable int id){

        return ciudadService.listarCiudades(id);
    }

    @GetMapping("/api/ciudad/buscar/{id}")
    public Ciudad buscarCiudadXId(@PathVariable int id){
        return ciudadService.buscarCiudadXId(id);
    }

    @PutMapping("/api/ciudad/{id}")
    public Mensaje editarCiudad(@PathVariable int id, @RequestBody Ciudad ciudad){
        return ciudadService.updateCiudad(id,ciudad);
    }

    @DeleteMapping("/api/ciudad/{id}")
    public Mensaje borrarCiudad(@PathVariable int id){
        return ciudadService.borrarCiudad(id);
    }
}

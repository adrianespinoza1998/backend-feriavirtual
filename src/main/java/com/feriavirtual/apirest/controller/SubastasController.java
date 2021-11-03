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
import com.feriavirtual.apirest.models.Subastas;
import com.feriavirtual.apirest.service.ISubastasService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SubastasController {

    @Autowired
    private ISubastasService subastasService;

    @PostMapping("/api/subastas")
    public Mensaje crearSubasta(@RequestBody Subastas subastas){
        return subastasService.crearSubastas(subastas);
    }

    @GetMapping("/api/subastas/{id}")
    public List<Subastas> listarSubasta(@PathVariable int id){
        return subastasService.listarSubastas(id);
    }

    @GetMapping("/api/subastas/buscar/{id}")
    public Subastas getSubastaById(@PathVariable int id) {
        return subastasService.getSubastaXId(id);
    }

    @PutMapping("/api/subastas/{id}")
    public Mensaje updateSubasta(@PathVariable int id,
                                  @RequestBody Subastas subastas) {
        return subastasService.updateSubasta(id, subastas);
    }

    @DeleteMapping("/api/subastas/{id}")
    public Mensaje borrarSubasta(@PathVariable int id) {
        return subastasService.borrarSubasta(id);
    }

}

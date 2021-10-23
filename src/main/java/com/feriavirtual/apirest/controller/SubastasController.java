package com.feriavirtual.apirest.controller;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Subastas;
import com.feriavirtual.apirest.service.ISubastasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

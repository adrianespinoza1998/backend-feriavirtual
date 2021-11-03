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
import com.feriavirtual.apirest.models.Moneda;
import com.feriavirtual.apirest.service.IMonedaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MonedaController {

    @Autowired
    private IMonedaService monedaService;

    @PostMapping("/api/moneda")
    public Mensaje crearMoneda(@RequestBody Moneda moneda){
        return monedaService.crearMoneda(moneda);
    }

    @GetMapping("/api/moneda")
    public List<Moneda> listarMonedas(){
        return monedaService.listarMonedas();
    }

    @GetMapping("/api/moneda/{id}")
    public Moneda buscarMonedaXId(@PathVariable int id){
        return monedaService.buscarMonedaXId(id);
    }

    @PutMapping("/api/moneda/{id}")
    public Mensaje updateMoneda(@PathVariable int id, @RequestBody Moneda moneda){
        return monedaService.updateMoneda(id, moneda);
    }

    @DeleteMapping("/api/moneda/{id}")
    public Mensaje borrarMoneda(@PathVariable int id){
        return monedaService.borrarMoneda(id);
    }
}

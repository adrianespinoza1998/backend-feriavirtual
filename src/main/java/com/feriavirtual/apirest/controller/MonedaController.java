package com.feriavirtual.apirest.controller;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Moneda;
import com.feriavirtual.apirest.service.IMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MonedaController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IMonedaService monedaService;

    @PostMapping("/api/moneda")
    public Mensaje crearMoneda(@RequestBody Moneda moneda){
        return monedaService.crearMoneda(jdbcTemplate, moneda);
    }

    @GetMapping("/api/moneda")
    public List<Moneda> listarMonedas(){
        return monedaService.listarMonedas(jdbcTemplate);
    }

    @GetMapping("/api/moneda/{id}")
    public Moneda buscarMonedaXId(@PathVariable int id){
        return monedaService.buscarMonedaXId(jdbcTemplate, id);
    }

    @PutMapping("/api/moneda/{id}")
    public Mensaje updateMoneda(@PathVariable int id, @RequestBody Moneda moneda){
        return monedaService.updateMoneda(jdbcTemplate,id, moneda);
    }

    @DeleteMapping("/api/moneda/{id}")
    public Mensaje borrarMoneda(@PathVariable int id){
        return monedaService.borrarMoneda(jdbcTemplate,id);
    }
}

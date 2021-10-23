package com.feriavirtual.apirest.controller;

import com.feriavirtual.apirest.models.Contrato;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.service.IContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ContratoController {

    @Autowired
    private IContratoService contratoService;

    @PostMapping("/api/contrato")
    public Mensaje crearContrato(@RequestBody Contrato contrato){
        return contratoService.crearContrato(contrato);
    }

    @GetMapping("/api/contrato/{firmado}")
    public List<Contrato> listarContratos(@PathVariable int firmado){
        return contratoService.listarContratos(firmado);
    }

    @GetMapping("/api/contrato/{id}/{firmado}")
    public List<Contrato> listarContratosXUsuario(@PathVariable int id, @PathVariable int firmado){
        return contratoService.listarContratosXUsuario(id,firmado);
    }

    @GetMapping("/api/contrato/buscar/{id}")
    public Contrato getContratoXId(@PathVariable int id){
        return contratoService.buscarContratoPorId(id);
    }

    @PutMapping("/api/contrato/{id}")
    public Mensaje updateContrato(@PathVariable int id, @RequestBody Contrato contrato){
        return contratoService.updateContrato(contrato,id);
    }

    @DeleteMapping("/api/contrato/{id}")
    public Mensaje deleteContrato(@PathVariable int id){
        return contratoService.borrarContrato(id);
    }

}

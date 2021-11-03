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

import com.feriavirtual.apirest.models.DetalleSolProductos;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.service.IDetSolProdService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DetSolProdController {

    @Autowired
    private IDetSolProdService detSolProdService;

    @PostMapping("/api/det-sol-prod")
    public Mensaje crearDetSolProd(@RequestBody DetalleSolProductos detSolProd){
        return detSolProdService.crearDetSolProd(detSolProd);
    }

    @GetMapping("/api/det-sol-prod")
    public List<DetalleSolProductos> listarDetSolProd(){
        return detSolProdService.listarDetSolProd();
    }

    @GetMapping("/api/det-sol-prod/{id}")
    public DetalleSolProductos getDetSolProdXId(@PathVariable int id){
        return detSolProdService.getDetSolProdXId(id);
    }

    @GetMapping("/api/det-sol-prod/sol/{id}")
    public DetalleSolProductos getDetSolProdXSol(@PathVariable int id){
        return detSolProdService.getDetSolProdXSol(id);
    }

    @PutMapping("/api/det-sol-prod/{id}")
    public Mensaje updateDetSolProd(@PathVariable int id, @RequestBody DetalleSolProductos detSolProd){
        return detSolProdService.editarDetSolProd(id, detSolProd);
    }

    @DeleteMapping("/api/det-sol-prod/{id}")
    public Mensaje deleteContrato(@PathVariable int id){
        return detSolProdService.borrarDetSolProd(id);
    }

}

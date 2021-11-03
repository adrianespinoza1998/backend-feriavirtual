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
import com.feriavirtual.apirest.models.SolicitudProductos;
import com.feriavirtual.apirest.service.ISolicitudProductosService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SolicitudProductoController {

    @Autowired
    private ISolicitudProductosService solicitudProductosService;

    @PostMapping("/api/sol-prod")
    public Mensaje crearSolProd(@RequestBody SolicitudProductos solProd){
        return solicitudProductosService.crearSolicitudProducto(solProd);
    }

    @GetMapping("/api/sol-prod/{id}")
    public List<SolicitudProductos> listarSolProd(@PathVariable int id){
        return solicitudProductosService.listarSolicitudProductos(id);
    }

    @GetMapping("/api/sol-prod/usr/{id}")
    public List<SolicitudProductos> listarSolProdXUsr(@PathVariable int id){
        return solicitudProductosService.listarSolicitudProductosXUser(id);
    }

    @GetMapping("/api/sol-prod/buscar/{id}")
    public SolicitudProductos getSolProdById(@PathVariable int id) {
        return solicitudProductosService.buscarSolicitudProductoXId(id);
    }

    @PutMapping("/api/sol-prod/{id}")
    public Mensaje updateSolProd(@PathVariable int id,
                                 @RequestBody SolicitudProductos solProd) {

        return solicitudProductosService.editarSolicitudProducto(id, solProd);
    }

    @DeleteMapping("/api/sol-prod/{id}")
    public Mensaje borrarSolProd(@PathVariable int id) {
        return solicitudProductosService.borrarSolicitudProducto(id);
    }

}

package com.feriavirtual.apirest.controller;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.SolicitudProductos;
import com.feriavirtual.apirest.service.ISolicitudProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public SolicitudProductos getSubastaById(@PathVariable int id) {
        return solicitudProductosService.buscarSolicitudProductoXId(id);
    }

    @PutMapping("/api/sol-prod/{id}")
    public Mensaje updateSolicitud(@PathVariable int id,
                                 @RequestBody SolicitudProductos solProd) {

        return solicitudProductosService.editarSolicitudProducto(id, solProd);
    }

    @DeleteMapping("/api/sol-prod/{id}")
    public Mensaje borrarSubasta(@PathVariable int id) {
        return solicitudProductosService.borrarSolicitudProducto(id);
    }

}

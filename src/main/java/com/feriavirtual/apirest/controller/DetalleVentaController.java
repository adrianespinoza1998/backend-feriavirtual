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

import com.feriavirtual.apirest.models.DetalleVenta;
import com.feriavirtual.apirest.models.DetalleVentaJoin;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.service.IDetVentaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DetalleVentaController {

    @Autowired
    private IDetVentaService detVentaService;

    @PostMapping("/api/det-venta")
    public Mensaje crearDetVenta(@RequestBody DetalleVenta detalleVenta){
        return detVentaService.crearDetVenta(detalleVenta);
    }

    @GetMapping("/api/det-venta")
    public List<DetalleVentaJoin> listarDetVenta(){
        return detVentaService.listarDetalleVenta();
    }

    @GetMapping("/api/det-venta/{id}")
    public DetalleVentaJoin getDetalleVentaXId(@PathVariable int id){
        return detVentaService.buscarDetVentaXId(id);
    }

    @PutMapping("/api/det-venta/{id}")
    public Mensaje updateDetVenta(@PathVariable int id, @RequestBody DetalleVenta detalleVenta){
        return detVentaService.updateDetVenta(id, detalleVenta);
    }

    @DeleteMapping("/api/det-venta/{id}")
    public Mensaje deleteDetVenta(@PathVariable int id){
        return detVentaService.deleteDetVenta(id);
    }

}

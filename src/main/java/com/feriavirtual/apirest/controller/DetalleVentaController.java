package com.feriavirtual.apirest.controller;

import com.feriavirtual.apirest.models.DetalleVenta;
import com.feriavirtual.apirest.models.DetalleVentaJoin;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.service.IDetVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DetalleVentaController {

    @Autowired
    private IDetVentaService detVentaService;

    @PostMapping("/api/det-venta")
    public Mensaje crearContrato(@RequestBody DetalleVenta detalleVenta){
        return detVentaService.crearDetVenta(detalleVenta);
    }

    @GetMapping("/api/det-venta")
    public List<DetalleVentaJoin> listarContratos(){
        return detVentaService.listarDetalleVenta();
    }

    @GetMapping("/api/det-venta/{id}")
    public DetalleVentaJoin getDetalleVentaXId(@PathVariable int id){
        return detVentaService.buscarDetVentaXId(id);
    }

    @PutMapping("/api/det-venta/{id}")
    public Mensaje updateContrato(@PathVariable int id, @RequestBody DetalleVenta detalleVenta){
        return detVentaService.updateDetVenta(id, detalleVenta);
    }

    @DeleteMapping("/api/det-venta/{id}")
    public Mensaje deleteContrato(@PathVariable int id){
        return detVentaService.deleteDetVenta(id);
    }

}

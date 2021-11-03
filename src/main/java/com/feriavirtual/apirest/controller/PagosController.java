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
import com.feriavirtual.apirest.models.Pagos;
import com.feriavirtual.apirest.models.PagosJoin;
import com.feriavirtual.apirest.service.IPagosService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PagosController {

    @Autowired
    private IPagosService pagosService;

    @PostMapping("/api/pagos")
    public Mensaje crearPagos(@RequestBody Pagos pagos){
        return pagosService.crearPago(pagos);
    }

    @GetMapping("/api/pagos")
    public List<PagosJoin> listarPagos(){
        return pagosService.listarPagos();
    }

    @GetMapping("/api/pagos/usr/{id}")
    public List<PagosJoin> listarPagosXUsuario(@PathVariable int id){
        return pagosService.listarPagosXUsuario(id);
    }

    @GetMapping("/api/pagos/{id}")
    public List<PagosJoin> listarPagosXIdSolicitud(@PathVariable int id){
        return pagosService.listarPagosXIdSolicitud(id);
    }

    @GetMapping("/api/pagos/buscar/{id}")
    public Pagos getPagosById(@PathVariable int id) {
        return pagosService.getPagoXId(id);
    }

    @PutMapping("/api/pagos/{id}")
    public Mensaje updatePago(@PathVariable int id,
                              @RequestBody Pagos pagos) {
        return pagosService.editarPago(id, pagos);
    }

    @DeleteMapping("/api/pagos/{id}")
    public Mensaje borrarPago(@PathVariable int id) {
        return pagosService.eliminarPago(id);
    }
}

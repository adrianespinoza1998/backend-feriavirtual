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
import com.feriavirtual.apirest.models.TipoProducto;
import com.feriavirtual.apirest.service.ITipoProductoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TipoProductoController {

    @Autowired
    private ITipoProductoService tipoProductoService;

    @PostMapping("/api/tipo-producto")
    public Mensaje crearTipoProducto(@RequestBody TipoProducto tipoProducto){
        return tipoProductoService.crearTipoProducto(tipoProducto);
    }

    @GetMapping("/api/tipo-producto")
    public List<TipoProducto> listarTipoProducto (){
        return tipoProductoService.listarTipoProducto();
    }

    @GetMapping("/api/tipo-producto/{id}")
    public TipoProducto buscarTipoProducto(@PathVariable int id){
        return tipoProductoService.getTipoProductoXId(id);
    }

    @PutMapping("/api/tipo-producto/{id}")
    public Mensaje editarTipoProducto(@PathVariable int id, @RequestBody TipoProducto tipoProducto){
        return tipoProductoService.updateTipoProducto(id, tipoProducto);
    }

    @DeleteMapping("/api/tipo-producto/{id}")
    public Mensaje borrarTipoProducto(@PathVariable int id){
        return tipoProductoService.borrarTipoProducto(id);
    }
}

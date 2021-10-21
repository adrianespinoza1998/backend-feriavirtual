package com.feriavirtual.apirest.controller;

import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.TipoProducto;
import com.feriavirtual.apirest.service.ITipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TipoProductoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

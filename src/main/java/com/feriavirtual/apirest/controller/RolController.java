package com.feriavirtual.apirest.controller;

import com.feriavirtual.apirest.models.Roles;
import com.feriavirtual.apirest.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/api/rol")
    public List<Roles> listarRoles(){
        return rolService.listarRoles();
    }
}

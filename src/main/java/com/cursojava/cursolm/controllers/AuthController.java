package com.cursojava.cursolm.controllers;

import com.cursojava.cursolm.dao.UsuarioDAO;
import com.cursojava.cursolm.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired  //crea la instancia y la comparte en memoria
    private UsuarioDAO usuarioDAO;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)//valor de url = usuario
    public String login(@RequestBody Usuario usuario) {    //transforma el json a un user

        return (usuarioDAO.verificarEmailPassword(usuario)) ? "OK" : "FAIL";
    }
}

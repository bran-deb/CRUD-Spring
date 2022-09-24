package com.cursojava.cursolm.controllers;

import com.cursojava.cursolm.dao.UsuarioDAO;
import com.cursojava.cursolm.models.Usuario;
import com.cursojava.cursolm.utilities.EncryptService;
import com.cursojava.cursolm.utilities.EncryptServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired  //crea la instancia y la comparte en memoria
    private UsuarioDAO usuarioDAO;

    private EncryptService encryptService;

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)//valor de url = usuario
    public Usuario getUsuario(@PathVariable Long id, Usuario usuario) {
        usuario.setId(id);
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("email@email.com");
        usuario.setTelefono("123456");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)//valor de url = usuario
    public List<Usuario> getUsuarios() {
        return usuarioDAO.getUsuarios();
    }

    @RequestMapping(value = "api/usuario", method = RequestMethod.POST)//valor de url = usuario
    public void registerUser(@RequestBody Usuario usuario) {    //transforma el json a un user

        encryptService.encryptPassword(usuario.getPassword());
//        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);//ENCRYPTOR
//        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());     //ENCRIPTADO
//        usuario.setPassword(hash);
//        usuarioDAO.registerUser(usuario);
    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.POST)
    public Usuario update(@PathVariable Long id, Usuario usuario) {
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("email@email.com");
        usuario.setTelefono("123456");
        usuarioDAO.update(id);
        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        usuarioDAO.eliminar(id);
    }
}

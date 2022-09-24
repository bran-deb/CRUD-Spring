package com.cursojava.cursolm.dao;

import com.cursojava.cursolm.models.Usuario;

import java.util.List;

public interface UsuarioDAO {

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void update(Long id);

    void registerUser(Usuario usuario);

    boolean verificarEmailPassword(Usuario usuario);
}

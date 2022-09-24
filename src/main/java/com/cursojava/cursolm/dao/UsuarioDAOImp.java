package com.cursojava.cursolm.dao;

import com.cursojava.cursolm.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository     //accede al repo de la DB
@Transactional  //arma consultas sql a la DB
public class UsuarioDAOImp implements UsuarioDAO {


    @PersistenceContext
    private EntityManager entityManager;    //sirve para hacer la DB connection

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";  //usuario(nombre de la clase)
        return (List<Usuario>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registerUser(Usuario usuario) {
        entityManager.merge(usuario);   //merge (add & update) entidades
    }


    @Override
    public void update(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
    }


    @Override
    public boolean verificarEmailPassword(Usuario usuario) {
//        String query = "FROM Usuario WHERE email = :email AND password = :password";  //usuario(nombre de la clase o model)
        String query = "FROM Usuario WHERE email = :email";  //usuario(nombre de la clase o model)
        List<Usuario> lista = entityManager.createQuery(query).setParameter("email", usuario.getEmail()).getResultList();
        System.out.println(lista);

        if (lista.isEmpty()) return false;

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);//ENCRYPTOR
        System.out.println("argon2 = " + argon2);
        String passwordHashed = lista.get(0).getPassword();//OBTIENE PASSWORD DE LA DB
        System.out.println("paHashed = " + passwordHashed);
        String password = usuario.getPassword();            //PASSWORD QUE LE PASAMOS
        System.out.println("password = " + password);
        return argon2.verify(passwordHashed, password);
    }
}

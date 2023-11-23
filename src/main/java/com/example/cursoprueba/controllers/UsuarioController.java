package com.example.cursoprueba.controllers;

import com.example.cursoprueba.dao.UsuarioDao;
import com.example.cursoprueba.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "api/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario= new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("apellido");
        usuario.setEmail("holasoyun@hotmail.com");
        usuario.setTelefono("7898989");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios() {
        return  usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/registrarUsuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);

    }


    @RequestMapping(value = "usuario1")
    public Usuario editar(){
        Usuario usuario= new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("apellido");
        usuario.setEmail("holasoyun@hotmail.com");
        usuario.setTelefono("7898989");
        return usuario;
    }

    @RequestMapping(value = "api/eliminarUsuario/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        usuarioDao.eliminar(id);
    }

    @RequestMapping(value = "usuario3")
    public Usuario buscar() {
        Usuario usuario= new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("apellido");
        usuario.setEmail("holasoyun@hotmail.com");
        usuario.setTelefono("7898989");
        return usuario;
    }
}

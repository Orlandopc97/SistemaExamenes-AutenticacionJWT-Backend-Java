package com.Orlpc.sistema_examenes_backend.controllers;

import com.Orlpc.sistema_examenes_backend.entitties.Rol;
import com.Orlpc.sistema_examenes_backend.entitties.Usuario;
import com.Orlpc.sistema_examenes_backend.entitties.UsuarioRol;
import com.Orlpc.sistema_examenes_backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@RestController //Reconocer que es el controler
//MAPEO de/para las solicitudes del cliente //para la parte de usuario
@RequestMapping("/usuarios")//Para acceder a esta APIRest sera por medio de la ruta "/usuario"
@CrossOrigin("*") //Permitir a cualquier petición (get, post, put, delete,patch,etc)
public class UsuarioController {

    //En/Para el controller se inyecta el service "servicio"
    //Inyeccion de dependencias
    @Autowired
    UsuarioService usuarioService;

    //Peticion POST guardar usuario
    @PostMapping("/")           //Mandar el usuario a guardar
    public Usuario saveUsuario (@RequestBody Usuario usuario) throws Exception{
                                    //Objeto usuario
        usuario.setPerfil("default.png");//Agregar una imagen.png al atributo perfil por defecto
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol  = new Rol(); //Objeto Rol
        rol.setIdRol(2L);
        rol.setNombreRol("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol(); //Se setean los dos objetos al objeto(entidad) usuarioRol
        usuarioRol.setUsuario(usuario); //Setea Objeto Usuario
        usuarioRol.setRol(rol);         //Setea Objeto Rol

        usuarioRoles.add(usuarioRol);   //Agrega el objeto usuario Rol a el conjunto usuario roles
    return usuarioService.saveUsuario(usuario,usuarioRoles);

    }

    //Petición GET  para obtener Usuario
                 //Los {} son cuando pasas una variable, ejemplo "username"
    @GetMapping("/{username}")
    public Usuario getUsuario(@PathVariable ("username") String username){
        return  usuarioService.getUsuario(username);

    }

    //Petición DELETE para eliminar un usuario
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable ("id") Long id){
        usuarioService.deleteUsuario(id);
    }

}

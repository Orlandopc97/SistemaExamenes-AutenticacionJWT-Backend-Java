package com.Orlpc.sistema_examenes_backend.services.implementation;

import com.Orlpc.sistema_examenes_backend.entitties.Usuario;
import com.Orlpc.sistema_examenes_backend.entitties.UsuarioRol;
import com.Orlpc.sistema_examenes_backend.repositories.RolRepository;
import com.Orlpc.sistema_examenes_backend.repositories.UsuarioRepository;
import com.Orlpc.sistema_examenes_backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

//Logica de negocio

//Servicio del sistema
@Service                                    //Implemeta la interface para implementar los metodos abstractos
public class UsuarioServiceImplementation implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository; //inyeccion de dependencias

    @Autowired
    private RolRepository rolRepository;

    //Al ser metodos que son definidos en una interfaz se deben inplementar obligatoriamente por lo menos una vez
    //Y se sobrescriben @Override para implementarlos


    //Registro Usuario
    //metodo implementado de la interface UsuarioService
    @Override       //guarda los datos de usuario y el rol que se le asignara con la relacion en la entidad "tabla" UsuarioRol
    public Usuario saveUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {

        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername()); //Buscar si el usuario con ese username existe

        if (usuarioLocal != null){//si el usuario lo encontro y es diferente de null mostrar exception de que ese nombre de usuario ya existe
            System.out.println("NAME ALREADY IN USE");
            throw new Exception("El usuario ya esta presente"); //throw se utiliza normalmente para lanzar excepciones comprobadas o no comprobadas

        }else {//Si el nombre de usuario no existe
            //Obtener los roles del conjunto de roles
            for(UsuarioRol usuariorol : usuarioRoles){
                //guardar el rol que se le esta pasando//Guardar los roles
                rolRepository.save(usuariorol.getRol());//Se va a guardar el Rol que se le esta pasando
            }
            //agregar todos los roles al usuario que se crea
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            //guardar el usuario y lo pasa a usuarioLocal
            usuarioLocal = usuarioRepository.save(usuario);
        }
        //retorna el usuario creado "usuarioLocal"
        return usuarioLocal;
    }

    @Override                 //Lo recibe :
    public Usuario getUsuario(String username) {
        //Solo se retorna el usuario por medio del username que lo escribira el cliente y lo recibe :
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void deleteUsuario(Long idUsuario) {
         //elimina el usuario por medio del id que el cliente manda
         usuarioRepository.deleteById(idUsuario);


    }


}


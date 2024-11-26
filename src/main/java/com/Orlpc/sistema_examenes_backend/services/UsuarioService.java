package com.Orlpc.sistema_examenes_backend.services;

import com.Orlpc.sistema_examenes_backend.entitties.Rol;
import com.Orlpc.sistema_examenes_backend.entitties.Usuario;
import com.Orlpc.sistema_examenes_backend.entitties.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    //Definición de método guardar usuario
    public Usuario saveUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    //Definición de método obtener Usuario
                //obtener Usuario
                            //obtener por username
    public Usuario getUsuario(String username);


    //Definición de método eliminar Usuario
    public void deleteUsuario(Long idUsuario);
}



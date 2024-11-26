package com.Orlpc.sistema_examenes_backend.entitties;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    private Long idRol;
    private String nombreRol;

    //Aqui se pone que un rol puede pertener a muchos usuarios(ejemplo rol="editor", muchos usuarios pueden ser editores y tener las credenciales para editar, rol="invitado"
    //Por eso rol"one" puede pertenecer a muchos "many"

                //Si algun rol se elimina se eliminara en cascada, el rol que este relacionado a la los usuarios
                                          //Cuando se hace una busqueda sera perezosa, se tiene que indicar cuando se llamara los datos
                                                                   //La entidad propietaria va a ser rol
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();
    //Muchos usuarios van a tener un mismo o un solo rol
    //Esto se indica en la clase UsuarioRol "many to One"




    //Metodos Getters and Setters
    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    //Constructor
    public Rol(){

    }
}

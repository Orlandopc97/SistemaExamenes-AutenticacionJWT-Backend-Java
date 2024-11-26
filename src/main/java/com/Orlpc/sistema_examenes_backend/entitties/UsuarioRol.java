package com.Orlpc.sistema_examenes_backend.entitties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;

//En esta clase, se indica que muchos reles van a pertenecer a este usuario
@Entity
public class UsuarioRol {

    //Relaciones one to many, many to one, many to many
    @Id                         //Se basa en una columna de base de datos con incremento automático y permite que la base de datos genere un nuevo valor con cada operación de inserción.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuarioRol; //identificador de esta clase

    /*especifica que la entidad hijo (Libro) está relacionada con exactamente una instancia de la entidad principal padre (Autor). Esto se refleja en el diseño de la base de datos,
     donde la entidad hijo contiene una columna que hace referencia a la clave primaria de la entidad principal.*/
                        /*  EAGER (ansioso): Indica que la relación debe de ser cargada al momento de cargar la entidad.
                        LAZY (perezoso): Indica que la relación solo se cargará cuando la propiedad sea leída por primera vez.*/
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario; //Objeto usuario (contiene todos los atributos de la clase entidad usuario)
    //EAGER: ANSIOSO = Es para cuando quieres que te devuelva todos los datos que esta relacionado ese usuario, te los de



    //Aqui se indica la relacion que esta en la clase Rol
    @ManyToOne
    private Rol rol; //Objeto rol (contiene todos los atributos de la clase entidad Rol)



    //Metodos Getters and Setters
    public long getIdUsuarioRol() {
        return idUsuarioRol;
    }

    public void setIdUsuarioRol(long idUsuarioRol) {
        this.idUsuarioRol = idUsuarioRol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    //Constructor vacio
    public UsuarioRol(){

    }
}

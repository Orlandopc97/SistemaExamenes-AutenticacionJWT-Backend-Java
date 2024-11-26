package com.Orlpc.sistema_examenes_backend.entitties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//extends: Se utiliza para indicar que una clase hereda de otra clase, es decir, reutiliza y anula el código de la clase supertipo.
//implements: Se utiliza para indicar que una clase implementa una o más interfaces,


/*
Crear package entity y clase Usuario.java
*/

//Mapeo de entidad para BD
@Entity         //Indicar nombre de la tabla en BD
@Table(name = "usuario")
public class Usuario implements UserDetails {
                      /*La clase UserDetails es una interfaz de Spring Security que proporciona
                        información básica sobre un usuario, como su nombre de usuario, contraseña,
                        roles y autorizaciones. Implementar metodos*/

    //Propiedades, atributos de la clase

    @Id //Indicar el identificador de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Que el ientificador sea autoincrementable
    private Long id;

    //Datos para usuario
    private String username;
    private String password;
    //Datos personales del usuario
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    //Si el usuario tiene permitido realizar examenes, preguntas
    private boolean enabled = true;
    private String perfil;

    //Un usuario podra tener muchos roles
                //Cascade en JPA: Cuando realizamos alguna acción en la ENTIDAD OBJETIVO, la misma acción se aplicara a sus ENTIDADES ASOCIADAS para simplificar las operaciones

    //Aqui es obtener los roles de un usuario, todos los roles de ese usuario
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonIgnore//deserealizacion omita el json--
    private Set<UsuarioRol> usuarioRoles = new HashSet<>(); //no tiene orden de elementos //no tiene elementos duplicados
    //Cuando se le haga algo a la entidad "usuario" afectara a la entidades hijas(relacionadas) "Usuariorol"
    //EAGER: ANSIOSO = Es para cuando quieres que te devuelva todos los datos que esta relacionado ese usuario, te los de
    //LAZY: PERESOZO = Si esta en modo peresozo no te podra devolver los datos relacionados con ese usuario (roles, examenes, etc)
    //MappedBy: apunta a la entidad propietaria de la relacion "ejemplo: Usuario", el propietario es usuario



    //Metodos Gettters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    //Métodos de la interfaz UserDetails
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();//default  true
        //¿La cuenta no ha expirado? true La cuenta estara activa un cierto tiempo
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();//default true
        //¿La cuenta no está bloqueada? true La cuenta estara bloqueada hasta que se desbloquee
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();//default true
        //¿Las credenciales no han expirado? true Las credenciales expiraran

    }

    public void setUsername(String username) {
        this.username = username;
    }

    //Método de la interfaz UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //Crando conjunto de autoridades, Crear la clase Autority
        Set<Authority> autoridades = new HashSet<>();
        //Obtener los roles y pasarlos como autoridades
        //De los roles de este usuario(usuarioRoles) vas a iterarlos en usuario Rol, crearas una autoridad obteniendo los nombres de roles y lo agregaras al conjunto "autoridades"
        this.usuarioRoles.forEach(usuarioRol -> {autoridades.add(new Authority(usuarioRol.getRol().getNombreRol()));
        });
        //Retornar el conjunto de autoridades
        return autoridades;

    }
    /////////////

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    //Constructor vacio
    public Usuario(){
    }

    //Relación con jpa @OneToOne

    /*
    *
    *
    *
    *
    * -Un alumno puede cursar solo una carrera
    *                    @OneToOne
    * Alumno @Entity--------------------Carrera @Entity
    * id @Id                               id @Id
    * nombre                            nombreCarrera
    * apellido
    * fechaNacimiento
    * -Metodos getters                  -Metodos getters
    *  and setters                       and setters
    * -Contructor vacio                 -Contructor vacio
    * -Constructor con parametros       -Constructor con parametros
    *
    *
    *Cuando es una relación "uno a uno"
    *   -Se establece la relacion mediante un objeto,
    *       Es decir Un ALUMNO va a tener dentro UN objeto carrera o que UNA CARRERA
    *       Dependiendo de que lado tiene mas sentido crear el objeto
    *       Ejemplo: al alumno le interesa mas saber a que carrera esta inscrito o a la carrrera le interesa saber el alumno
    *
    *   Se añade el objeto a la clase alumno
    *       Al alumno le interesa mas saber a que carrera esta inscrito
    *
    *   Se crea la relaciio
    *
    *       @OneToOne <-------------------------- Para reconocer esta relacion esta la anotacion (configurada y mapeada)
    *       -private Carrera carrera  ----------->"objeto tipo carrera" en clase alumno
    *   -Como se añade como atributo, se redefine el contructor con todos los parametros y se agrega, ademas de los metodos getter y setter
    *   -Cuando se crea el objeto alumno tambien se debe crear el objeto carrera con todos los valores de suu atributos debe ir tambien el de carrera y lo
    *
    *   ////////
    *   usuario(todos los atributos tambien el de rol)
    *   Rol(todos los atributos con el de usuario)
    *   UsuarioRol(id, usuario y rol)
    *   ///////
    *
    *   //Relación con jpa @OneToMany
    *
    * -Un alumno puede tener muchas materias
    *                    @OneToMany
    * Carrera @Entity--------------------Materia @Entity
    * id @Id                               id @Id                           //Cuando es 1 a N "muchos", la FK que asocia siempre sera del lado de la N "muchos"
    * nombre                            nombreMateria                       //Ejemplo 1 carrera tiene la materia matematicas, matematicas tiene una FK que es el id de la carrera para identificar
    *                                   tipo (bimestral,semestral)          //A nivel logico"codigo"(modelado de clases), para hacer una relacion tiene que haber una lista de objetos del lado del 1
    *                                                                       //Porque tiene sentido que la carrera conozca la lista de carreras (onjeto carrera)que tiene que las materias conocer la carrera
    * -Metodos getters                  -Metodos getters
    *  and setters                       and setters
    * -Contructor vacio                 -Contructor vacio
    * -Constructor con parametros       -Constructor con parametros     //El constructor se redefine para agregar el atributo lista de objetos de materia en la clase carrera en este caso
    *
    * Crear lista de objetos materia
    * @OneToMany
    * -private LinkedList<Materia> listaMaterias  //Asi se hace la relacion de 1 a N //Cambia si es unidireccional o bidireccional la relacion
    *
    *
    * */


}

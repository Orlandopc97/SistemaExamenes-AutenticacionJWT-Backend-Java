package com.Orlpc.sistema_examenes_backend.entitties;
//Clase para obtener las autoidades(nombre de rol de usuario)
import org.springframework.security.core.GrantedAuthority;
                        //implemetar la interfaz GrandtedAuhority para sobrescribir metodos,
                        //como el  de obtener autoridad para pasarselo por un campo llamado authority
public class Authority implements GrantedAuthority {

    private String authority;

    //Constructor
    public Authority(String authority){
        this.authority = authority;
    }

    //Sobrescribir el metodo obtener autoridad para poder pasarla al campo authority
    @Override //Obtener rol del usuario y ahora sera una autoridad
    public String getAuthority() {
        return this.authority;
    }
}



/*
*
* La interfaz GrantedAuthority en Spring Security representa una autoridad o privilegio que se otorga a un usuario
  autenticado. Esta interfaz define las acciones que puede realizar un usuario.

  Spring Security utiliza las autoridades para realizar la autorización. Si un usuario tiene la autoridad necesaria,
  recibe autorización. En caso contrario, el marco de trabajo niega el acceso y genera la AccessDeniedException.

  En Spring Security, los roles y las autoridades se utilizan a menudo de forma intercambiable,
  pero hay una sutil diferencia entre ambos:

    * Las autoridades son características de control de acceso a nivel granular y representan
    permisos individuales.

    * Los roles se utilizan normalmente para agrupar un conjunto de autoridades y se preceden con ROLE_.

    Por ejemplo, un rol como "ROLE_ADMIN" podría implicar un conjunto de autoridades, como "read", "write" y "delete".
*
*
*
*/
package com.Orlpc.sistema_examenes_backend.repositories;

import com.Orlpc.sistema_examenes_backend.entitties.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

                                    //Extiende de jparepository de tipo Usuario, identificador tipo long
                                            //La clase jpaRepositorie que se hereda tiene metodos para poder utilizarlos
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    //metodo abstracto encontrar usuario por nombre
                   //Lo reconoce spring
    public Usuario findByUsername(String userName);

}

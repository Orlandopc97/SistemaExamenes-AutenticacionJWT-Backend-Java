package com.Orlpc.sistema_examenes_backend;

import com.Orlpc.sistema_examenes_backend.entitties.Rol;
import com.Orlpc.sistema_examenes_backend.entitties.Usuario;
import com.Orlpc.sistema_examenes_backend.entitties.UsuarioRol;
import com.Orlpc.sistema_examenes_backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication							//Prueba para guardar usuario
public class SistemaExamenesBackendApplication implements CommandLineRunner {

	//inyectar servicio
	@Autowired//Cuando inyectas el servicio"interfaz" va a llamar a un metodo
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	//metodo implementado de commandLineRunner para ejecutar directamente el usuario a crear, poder mostrar los usuarios en consola o cualquier otra cosa
	@Override
	public void run(String... args) throws Exception {
		//CREAR USUARIO
		/*
		Usuario usuario = new Usuario();
		usuario.setNombre("Orlando");
		usuario.setApellido("Ramirez");
		usuario.setUsername("Orlapc88");
		usuario.setPassword("passopc88");
		usuario.setEmail("Orlandopc88@gmail.com");
		usuario.setTelefono("7334356699");
		usuario.setPerfil("foto.png");
		//usuario.setEnabled(false);			//creaba objeto usuario completo

		//CREAR ROL
		Rol rol = new Rol();
		rol.setIdRol(1L);
		rol.setNombreRol("ADMIN");				//creaba objeto rol completo

		//RELACIONAR LOS 2 OBJETOS// agregar a la tabla usuariorol el usuario y el rol
		Set<UsuarioRol> usuarioRoles = new HashSet<>();     //Los dos objetos se setean en usuarioRol

		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);								//El objeto usuarioRol que tiene los dos objetos usuario y rol
		usuarioRol.setUsuario(usuario);						//este objeto usuarioRol se agrega al conjunto usuarioRoles
		usuarioRoles.add(usuarioRol);						//aqui se puede agregar la cantidad de usuarios que se desee

		Usuario usuarioGuardado = usuarioService.saveUsuario(usuario,usuarioRoles);
		System.out.println(usuarioGuardado.getUsername());

		 */



	}
}

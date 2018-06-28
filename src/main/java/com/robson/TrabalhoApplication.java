package com.robson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.robson.model.Usuario;

@SpringBootApplication
public class TrabalhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoApplication.class, args);
		
		Usuario usuario = new Usuario(null, "max", "max@gmail.com", "csgbd", 1);
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
	}
}

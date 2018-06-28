package com.robson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.robson.model.Usuario;
import com.robson.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Optional<Usuario> findById(Integer id) {
		return repository.findById(id);
	}

	public Usuario findByNome(String nome) {
		return repository.findByNome(nome);
	}

	public Usuario save(Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		return repository.save(usuario);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
package com.robson.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.robson.model.Usuario;
import com.robson.service.UsuarioService;

@Repository
@Transactional
public class UserSS implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.findByNome(nome);
		if (usuario == null)
			throw new UsernameNotFoundException("Usuário não enontrado!");
		return usuario;
	}
}
package com.robson.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.robson.model.Usuario;
import com.robson.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping("/usuarios")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/usuarios/usuarios");
		mv.addObject("usuarios", service.findAll());
		return mv;
	}

	@GetMapping("/usuarios/adicionar")
	public ModelAndView add(Usuario usuario) {
		ModelAndView mv = new ModelAndView("/usuarios/usuarioForm");
		mv.addObject("usuario", usuario);
		return mv;
	}

	@GetMapping("/usuarios/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {
		return add(service.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado")));
	}

	@GetMapping("/usuarios/deletar/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return findAll();
	}

	@PostMapping("/usuarios/salvar")
	public ModelAndView save(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return add(usuario);
		}
		service.save(usuario);
		return findAll();
	}
}
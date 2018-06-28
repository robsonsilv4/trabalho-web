package com.robson.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.robson.model.Produto;
import com.robson.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping("/produtos")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/produtos/produtos");
		mv.addObject("produtos", service.findAll());
		return mv;
	}

	@GetMapping("/produtos/adicionar")
	public ModelAndView add(Produto produto) {
		ModelAndView mv = new ModelAndView("/produtos/produtoForm");
		mv.addObject("produto", produto);
		return mv;
	}

	@GetMapping("/produtos/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {
		return add(service.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado")));
	}

	@GetMapping("/produtos/deletar/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		service.deleteById(id);
		return findAll();
	}

	@PostMapping("/produtos/salvar")
	public ModelAndView save(@Valid Produto produto, BindingResult result) {
		if (result.hasErrors()) {
			return add(produto);
		}
		service.save(produto);
		return findAll();
	}
}
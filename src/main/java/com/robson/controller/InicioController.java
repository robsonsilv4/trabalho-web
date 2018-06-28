package com.robson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.robson.model.Produto;
import com.robson.service.ProdutoService;

public class InicioController {
	@Autowired
	private ProdutoService service;

	@GetMapping("/")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("index");
		List<Produto> produtos = service.find5();
		mv.addObject("produtos", produtos);
		return mv;
	}
}

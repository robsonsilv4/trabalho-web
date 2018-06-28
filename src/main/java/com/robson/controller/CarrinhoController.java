package com.robson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.robson.service.CarrinhoService;
import com.robson.service.ProdutoService;

@Controller
public class CarrinhoController {
	@Autowired
	private CarrinhoService carrinho;

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/carrinho")
	public ModelAndView carrinho() {
		ModelAndView modelAndView = new ModelAndView("/carrinho");
		modelAndView.addObject("produtos", carrinho.listar());
		modelAndView.addObject("total", carrinho.total());
		return modelAndView;
	}

	@GetMapping("/carinho/adicionar/{id}")
	public ModelAndView add(@PathVariable("id") Integer id) {
		produtoService.findById(id).ifPresent(carrinho::adicionar);
		return new ModelAndView("redirect:/carrinho");
		// return carrinho();
	}

	@GetMapping("/carrinho/remover/{id}")
	public ModelAndView remove(@PathVariable("id") Integer id) {
		produtoService.findById(id).ifPresent(carrinho::remover);
		return carrinho();
	}
}
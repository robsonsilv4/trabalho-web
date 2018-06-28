package com.robson.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.robson.model.Produto;

// @Component
// @SessionScope

@Service
@Component
@SessionScope
// @Scope(value = "session")
public class CarrinhoService {
	private List<Produto> produtos = new ArrayList<>();

	public void adicionar(Produto produto) {
		produtos.add(produto);
	}

	public List<Produto> listar() {
		return produtos;
	}

	public void remover(Produto produto) {
		produtos.remove(produto);
	}

	public Integer quantidade() {
		return produtos.size();
	}

	public double total() {
		double total = 0;
		for (Produto produto : produtos) {
			total += produto.getPreco();
		}
		return total;
	}
}
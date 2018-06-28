package com.robson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robson.model.Produto;
import com.robson.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public Optional<Produto> findById(Integer id) {
		return repo.findById(id);
	}
	
	public List<Produto> find5() {
		return repo.findTop5ByOrderByIdDesc();
	}

	public List<Produto> findAll() {
		return repo.findAll();
	}

	public Produto save(Produto produto) {
		return repo.save(produto);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
package com.robson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robson.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	List<Produto> findTop5ByOrderByIdDesc();
}
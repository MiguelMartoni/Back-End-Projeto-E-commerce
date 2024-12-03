package com.miguelmartoni.aula01.repository;

import com.miguelmartoni.aula01.model.Produto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByNomeContaining(String nome, Sort s);

}
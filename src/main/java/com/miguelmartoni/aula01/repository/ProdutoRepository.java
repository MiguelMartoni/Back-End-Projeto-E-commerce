package com.miguelmartoni.aula01.repository;

import com.miguelmartoni.aula01.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}
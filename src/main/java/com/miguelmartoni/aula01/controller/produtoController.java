package com.miguelmartoni.aula01.controller;
import com.miguelmartoni.aula01.model.Produto;
import com.miguelmartoni.aula01.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class produtoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> get(@RequestParam(required = false, defaultValue = "nome") String sortField,
                             @RequestParam(required = false, defaultValue = "asc") String sortDirection,
                             @RequestParam(required = false) boolean sortByPrice,
                             @RequestParam(required = false) String filter)   {

        if (sortByPrice) {
            sortField = "preco";
        }

        Sort.Direction direction;
        if (sortDirection.equalsIgnoreCase("desc")) {
            direction = Sort.Direction.DESC;
        } else {
            direction = Sort.Direction.ASC;
        }

        Sort sort = Sort.by(direction, sortField);

        if (filter == null || filter.isEmpty())
        return repository.findAll(sort);

        else
            return repository.findByNomeContaining(filter, sort);
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto){
        return repository.save(produto);
    }
}

package com.vendas.api.controller;

import com.vendas.api.exception.dto.Identificador;
import com.vendas.api.model.Categoria;
import com.vendas.api.repository.CategoriaRepository;
import com.vendas.api.service.CategoriaService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("categorias/api")
@RequiredArgsConstructor
public class CategoriaController {
    
    private final CategoriaRepository categoriaRepository;
    private final CategoriaService categoriaService;
    
    @GetMapping
    public List<Categoria> todas() {
        return categoriaRepository.findAll();
    }
    
    @GetMapping("buscar-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria findById(@PathVariable Long id) {
        return categoriaRepository.findById(id).
        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrado!"));
    }
    
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Categoria update(@RequestBody @Valid Categoria categoria) {
        return categoriaService.update(categoria);
    }
    
}

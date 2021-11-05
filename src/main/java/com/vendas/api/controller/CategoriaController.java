package com.vendas.api.controller;

import com.vendas.api.controller.apisw.CategoriaSwaggerApi;
import com.vendas.api.model.Categoria;
import com.vendas.api.repository.CategoriaRepository;
import com.vendas.api.service.CategoriaService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class CategoriaController implements CategoriaSwaggerApi {
    
    private final CategoriaRepository categoriaRepository;
    private final CategoriaService categoriaService;
    
    @Override
    public List<Categoria> todas() {
        return categoriaRepository.findAll();
    }
    
    @Override
    public Categoria findById(@PathVariable Long id) {
        return categoriaRepository.findById(id).
        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrado!"));
    }
    
    @Override
    public Categoria update(@RequestBody @Valid Categoria categoria) {
        return categoriaService.update(categoria);
    }

    @Override
    public void delete(Long id) {
        categoriaService.delete(id);
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
}

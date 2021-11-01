package com.vendas.api.service;

import com.vendas.api.model.Categoria;
import com.vendas.api.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
@RequiredArgsConstructor
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;
    
    @Transactional
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    @Transactional
    public Categoria update(Categoria categoriaUpdate) {
        Categoria novaCategoria = categoriaRepository.findById(categoriaUpdate.getId()).map(categoriaAtual -> {
            BeanUtils.copyProperties(categoriaUpdate, categoriaAtual, "id");
            categoriaRepository.save(categoriaAtual);
            return categoriaAtual;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada!"));
        return novaCategoria;
    }
    
}

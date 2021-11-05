package com.vendas.api.service;

import com.vendas.api.exception.NegocioException;
import com.vendas.api.model.Categoria;
import com.vendas.api.repository.CategoriaRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
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
    
    @Transactional
    public void delete(Long id) {
        categoriaRepository.findById(id)
        .map(cliente -> {
            categoriaRepository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Categoria não encontrada!"));
    }
    
    @Transactional
    public void deletar(Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if(categoriaOptional.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
    }
    
    private void validarCategoriaCadastrada(Categoria categoria) {
        Categoria categoriaEncontrada = categoriaRepository.findByNome(categoria.getNome());
        if(categoriaEncontrada != null && !categoriaEncontrada.getId().equals(categoria.getId())) {
            throw new NegocioException(String.format("A categoria %s já esta cadastrada", categoria.getNome().toUpperCase()));
        }
    }
    
}

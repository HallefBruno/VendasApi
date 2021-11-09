package com.vendas.api.controller;

import java.util.List;
import javax.validation.Valid;
import com.vendas.api.controller.apisw.ProdutoSwaggerApi;
import com.vendas.api.model.Produto;
import com.vendas.api.repository.ProdutoRepository;
import com.vendas.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProdutoController implements ProdutoSwaggerApi {
    
    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto update(@Valid Produto produto) {
        return produtoService.update(produto);
    }

    @Override
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
    }

    @Override
    public void delete(Long id) {
        produtoRepository.findById(id).map(produto -> {
            produtoRepository.deleteById(produto.getId());
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto não encontrado!"));
    }

    @Override
    public ResponseEntity<?> buscarPorCategoriaIdProdutoId(Long produtoId, Long categoriaId) {
        produtoRepository.findByIdAndCategoriaId(produtoId, categoriaId).map(produto -> {
            return ResponseEntity.ok().body(produto);
        });
        return new ResponseEntity<>("Nenhum produto encontrado!",HttpStatus.NO_CONTENT);
    }

    @Override
    public List<Produto> listarTodosPorCategoriaId(Long id) {
        return produtoRepository.findByCategoriaId(id);
    }

}

package com.vendas.api.service;

import com.vendas.api.model.Produto;
import com.vendas.api.repository.ProdutoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Transactional
    public Produto update(Produto produtoUpdate) {
        Produto novoProduto = produtoRepository.findById(produtoUpdate.getId()).map(produtoAtual -> {
            BeanUtils.copyProperties(produtoUpdate, produtoAtual, "id");
            produtoRepository.save(produtoAtual);
            return produtoAtual;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
        return novoProduto;
    }

}

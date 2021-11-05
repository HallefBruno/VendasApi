package com.vendas.api.controller.apisw;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import com.vendas.api.model.Produto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Produtos", tags = "Produtos")
@RequestMapping(value = "categoria{categoriaId}/produto")
public interface ProdutoSwaggerApi {
    
    @ApiOperation(value = "Salvar produto", nickname = "SalvarProduto")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@Valid @RequestBody Produto produto);

    @ApiOperation(value = "Atualizar produto", nickname = "UpdateProduto")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Produto update(@RequestBody @Valid Produto produto);

    @ApiOperation(value = "Buscar produto por Id")
    @GetMapping("buscar-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto buscarPorId(@PathVariable(name = "id", required = true) Long id);

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id", required = true) Long id);

    @ApiOperation(value = "Listar produtos por categoria id")
    @GetMapping("listar-todas-categoria-id/{id}")
    public List<Produto> listarTodosPorCategoriaId(@PathVariable(name = "id", required = true) Long id);

    @ApiOperation(value = "Buscar produto por categoria e produto")
    @GetMapping("puscar-por-categoria-id-produto-id")
    public Optional<Produto> buscarPorCategoriaIdProdutoId(@PathVariable(name = "produtoId", required = true) Long produtoId, @PathVariable(name = "categoriaId", required = true) Long categoriaId);

}

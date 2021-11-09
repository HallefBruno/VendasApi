package com.vendas.api.controller;

import com.vendas.api.model.Cliente;
import com.vendas.api.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@Api(value = "Clientes", tags = "Clientes")
@RestController
@RequestMapping("clientes/api")
@RequiredArgsConstructor
public class ClienteController {
    
    private final ClienteService clienteService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Salvar cliente", nickname = "SalvarCliente")
    public ResponseEntity<?> salvar(@Valid @RequestBody Cliente cliente, UriComponentsBuilder uriBuilder) {
        Cliente novo = clienteService.salvar(cliente);
        URI uri = uriBuilder.path("/buscar-por-id/{id}").buildAndExpand(novo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @GetMapping("buscar-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Buscar cliente por id", nickname = "BuscarClientePorId")
    public Cliente buscarPorId(@PathVariable(required = true) Long id) {
        return clienteService.buscarPorId(id);
    }
    
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atualizar cliente", nickname = "AtualizarCliente")
    public void update(@Valid @RequestBody Cliente cliente) {
        clienteService.update(cliente);
    }
    
    @GetMapping("todos")
    @ApiOperation(value = "Listar todos cliente", nickname = "ListarCliente")
    public List<Cliente> todos() {
        return clienteService.todos();
    }
    
}

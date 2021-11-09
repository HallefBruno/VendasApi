package com.vendas.api.service;

import com.vendas.api.model.Cliente;
import com.vendas.api.repository.ClienteRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ClienteService {
    
    private final ClienteRepository clienteRepository;
    
    @Transactional
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    @Transactional
    public Cliente update(Cliente clienteUpdate) {
        Cliente clienteAtual = clienteRepository.findById(clienteUpdate.getId())
        .map(cliente -> {
            BeanUtils.copyProperties(clienteUpdate, cliente,"id");
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente bão encontrado!"));
        return clienteAtual;
    }
    
    @Transactional
    public void deletar(Long id) {
        clienteRepository.findById(id).map(cliente -> {
            clienteRepository.delete(cliente);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente bão encontrado!"));
    }
    
    
    public Cliente buscarPorId(Long id) {
        Cliente clienteAtual = clienteRepository.findById(id).map(cliente -> {
            return cliente;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente bão encontrado!"));
        return clienteAtual;
    }
    
    public List<Cliente> todos() {
        return clienteRepository.findAll();
    }
}

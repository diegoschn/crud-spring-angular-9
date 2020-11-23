package br.com.crud.service;

import br.com.crud.exception.EntidadeNaoEncontradaException;
import br.com.crud.model.entity.Cliente;
import br.com.crud.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Integer id){
        return clienteRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void remover(Integer id) {
        clienteRepository
                .findById(id)
                .map( cliente -> {
                    clienteRepository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}

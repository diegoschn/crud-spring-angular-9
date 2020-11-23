package br.com.crud.rest;

import br.com.crud.exception.EntidadeNaoEncontradaException;
import br.com.crud.model.entity.Cliente;
import br.com.crud.model.repository.ClienteRepository;
import br.com.crud.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    public ClienteController(ClienteRepository clienteRepository, ClienteService clienteService){
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody  Cliente cliente){
        cliente = clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> pesquisar(@PathVariable Integer id){
        Optional<Cliente> clienteEncontrado = Optional.ofNullable(clienteService.buscarPorId(id));
        if(clienteEncontrado.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteEncontrado.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id,
                         @RequestBody Cliente cliente){
        Optional<Cliente> clienteEncontrado = Optional.ofNullable(clienteService.buscarPorId(id));
        if(clienteEncontrado.isPresent()){
            cliente.setId(id);
            Cliente clienteOk = clienteService.salvar(cliente);
            return ResponseEntity.ok(clienteOk);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Integer id){
        try{
            clienteService.remover(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
    }
}

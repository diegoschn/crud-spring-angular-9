package br.com.crud.rest;

import br.com.crud.exception.UsuarioCadastradoException;
import br.com.crud.model.entity.Usuario;
import br.com.crud.model.repository.UsuarioRepository;
import br.com.crud.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository usuarioRepository,
                UsuarioService usuarioService){
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario){
        try {
            usuario = usuarioService.salvar(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

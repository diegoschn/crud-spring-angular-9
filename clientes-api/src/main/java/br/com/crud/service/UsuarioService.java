package br.com.crud.service;

import br.com.crud.exception.UsuarioCadastradoException;
import br.com.crud.model.entity.Usuario;
import br.com.crud.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario){
        boolean exists = usuarioRepository.existsByUsername(usuario.getUsername());
        if(exists){
            throw new UsuarioCadastradoException(usuario.getUsername());
        }
        usuario = usuarioRepository.save(usuario);
        return usuario;
    }
}

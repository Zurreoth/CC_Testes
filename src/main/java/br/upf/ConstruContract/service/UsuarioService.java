package br.upf.ConstruContract.service;

import br.upf.ConstruContract.dto.UsuarioDTO;
import br.upf.ConstruContract.repository.UsuarioRepository;
import br.upf.ConstruContract.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public void cadastrarUsuario(Usuario usuario) {

        Optional<Usuario> usuarioOptional = this.usuarioRepository.findUsuarioByEmail(usuario.getEmail());

        if(usuarioOptional.isPresent()) {
            throw new IllegalStateException("Email Já Cadastrado");
        }

        this.usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Long id) {

        boolean exists = this.usuarioRepository.existsById(id);

        if(!exists) {
            throw new IllegalStateException(String.format("Usuario de id %d inexistente", id));
        }

        this.usuarioRepository.deleteById(id);
    }

    public void editarUsuario(Long id, UsuarioDTO usuarioDto) {

        Usuario usuario = this.usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Usuario de id %d inexistente", id)));

        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(usuarioDto.getSenha());

        this.usuarioRepository.save(usuario);

    }

    public Usuario getUsuarioById(Long usuarioId) {
        return this.usuarioRepository.getReferenceById(usuarioId);
    }

    public boolean login(UsuarioDTO usuarioDto) {
        Usuario usuario = this.usuarioRepository.findUsuarioByEmail(usuarioDto.getEmail())
                .orElseThrow(() -> new IllegalStateException("Email invalido"));

        if(usuario.getSenha().equals(usuarioDto.getSenha())) {
            return true;
        }

        throw new IllegalStateException("Senha incorreta");
    }
}

package br.upf.ConstruContract.converter;

import br.upf.ConstruContract.dto.UsuarioDTO;
import br.upf.ConstruContract.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    public Usuario toUsuario(UsuarioDTO dto) {
        return new Usuario(dto.getSenha(), dto.getEmail());
    }

}

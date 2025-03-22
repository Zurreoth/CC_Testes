package br.upf.ConstruContract.converter;

import br.upf.ConstruContract.dto.ContratanteDTO;
import br.upf.ConstruContract.model.Contratante;
import br.upf.ConstruContract.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContratanteConverter {

    @Autowired
    private UsuarioConverter usuarioConverter;

    public Contratante toContratante(ContratanteDTO dto) {
        return new Contratante(this.usuarioConverter.toUsuario(dto.getUsuarioDTO()));
    }

}

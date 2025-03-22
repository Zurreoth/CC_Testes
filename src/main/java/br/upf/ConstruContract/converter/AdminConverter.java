package br.upf.ConstruContract.converter;

import br.upf.ConstruContract.dto.AdminDTO;
import br.upf.ConstruContract.model.Admin;
import br.upf.ConstruContract.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter {

    @Autowired
    private UsuarioConverter usuarioConverter;

    public Admin toAdmin(AdminDTO dto) {
        return new Admin(this.usuarioConverter.toUsuario(dto.getUsuarioDTO()));
    }

}

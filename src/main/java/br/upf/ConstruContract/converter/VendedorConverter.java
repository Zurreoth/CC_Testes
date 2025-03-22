package br.upf.ConstruContract.converter;

import br.upf.ConstruContract.dto.VendedorDTO;
import br.upf.ConstruContract.model.Vendedor;
import br.upf.ConstruContract.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendedorConverter {

    @Autowired
    private UsuarioConverter usuarioConverter;

    public Vendedor toVendedor(VendedorDTO dto) {
        return new Vendedor(this.usuarioConverter.toUsuario(dto.getUsuarioDTO()));
    }
}

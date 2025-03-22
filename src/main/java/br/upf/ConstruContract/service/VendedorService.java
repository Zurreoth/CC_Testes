package br.upf.ConstruContract.service;

import br.upf.ConstruContract.converter.UsuarioConverter;
import br.upf.ConstruContract.converter.VendedorConverter;
import br.upf.ConstruContract.dto.VendedorDTO;
import br.upf.ConstruContract.model.Vendedor;
import br.upf.ConstruContract.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private VendedorConverter converter;

    public List<Vendedor> getVendedores() {
        return this.repository.findAll();
    }

    public void cadastrarVendedor(VendedorDTO vendedor) {
        this.repository.save(this.converter.toVendedor(vendedor));
    }

    public void excluirVendedor(Long id) {

        boolean exists = this.repository.existsById(id);

        if(!exists) {
            throw new IllegalStateException(String.format("Vendedor de id %d inexistente", id));
        }

        this.repository.deleteById(id);
    }

    public void editarVendedor(Long id, VendedorDTO vendedorDTO) {

        Vendedor vendedor = this.repository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Vendedor de id %d inexistente", id)));

        vendedor.setUsuario(this.usuarioConverter.toUsuario(vendedorDTO.getUsuarioDTO()));

        this.repository.save(vendedor);
    }

    public Vendedor getById(Long vendedorId) {
        return this.repository.getReferenceById(vendedorId);
    }
}

package br.upf.ConstruContract.service;

import br.upf.ConstruContract.converter.AdminConverter;
import br.upf.ConstruContract.converter.UsuarioConverter;
import br.upf.ConstruContract.dto.AdminDTO;
import br.upf.ConstruContract.model.Admin;
import br.upf.ConstruContract.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private AdminConverter converter;

    public List<Admin> getAdmins() {
        return this.repository.findAll();
    }

    public void cadastrarAdmin(AdminDTO admin) {
        this.repository.save(this.converter.toAdmin(admin));
    }

    public void excluirAdmin(Long id) {

        boolean exists = this.repository.existsById(id);

        if(!exists) {
            throw new IllegalStateException(String.format("Admin de id %d inexistente", id));
        }

        this.repository.deleteById(id);
    }

    public void editarAdmin(Long id, AdminDTO adminDTO) {

        Admin admin = this.repository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Admin de id %d inexistente", id)));

        admin.setUsuario(this.usuarioConverter.toUsuario(adminDTO.getUsuarioDTO()));

        this.repository.save(admin);
    }
}

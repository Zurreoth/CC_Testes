package br.upf.ConstruContract.service;

import br.upf.ConstruContract.converter.ContratanteConverter;
import br.upf.ConstruContract.converter.UsuarioConverter;
import br.upf.ConstruContract.dto.ContratanteDTO;
import br.upf.ConstruContract.model.Contratante;
import br.upf.ConstruContract.repository.ContratanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratanteService {

    @Autowired
    private ContratanteRepository repository;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private ContratanteConverter converter;

    public List<Contratante> getContratantes() {
        return this.repository.findAll();
    }

    public void cadastrarContratante(ContratanteDTO contratante) {
        this.repository.save(this.converter.toContratante(contratante));
    }

    public void excluirContratante(Long id) {

        boolean exists = this.repository.existsById(id);

        if(!exists) {
            throw new IllegalStateException(String.format("Contratante de id %d inexistente", id));
        }

        this.repository.deleteById(id);
    }

    public void editarContratante(Long id, ContratanteDTO contratanteDTO) {

        Contratante contratante = this.repository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Contrante de id %d inexistente", id)));

        contratante.setUsuario(this.usuarioConverter.toUsuario(contratanteDTO.getUsuarioDTO()));

        this.repository.save(contratante);
    }

    public Contratante getById(Long id) {
        return this.repository.getReferenceById(id);
    }
}

package br.upf.ConstruContract.service;

import br.upf.ConstruContract.converter.ProjetoConverter;
import br.upf.ConstruContract.dto.ProjetoDTO;
import br.upf.ConstruContract.model.Projeto;
import br.upf.ConstruContract.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProjetoConverter converter;

    public List<Projeto> getProjetos() {
        return this.repository.findAll();
    }

    public void cadastrarProjeto(ProjetoDTO projeto) {
        this.repository.save(this.converter.toProjeto(projeto));
    }

    public void excluirProjeto(Long id) {

        boolean exists = this.repository.existsById(id);

        if(!exists) {
            throw new IllegalStateException(String.format("Projeto de id %d inexistente", id));
        }

        this.repository.deleteById(id);
    }

    public void editarProjeto(Long id, ProjetoDTO projetoDTO) {

        Projeto projeto = this.repository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Projeto de id %d inexistente", id)));

        Projeto projetoNovo = this.converter.toProjeto(projetoDTO);

        projetoNovo.setId(id);

        this.repository.save(projetoNovo);
    }

    public Projeto getById(Long id) {
        return this.repository.getReferenceById(id);
    }

}

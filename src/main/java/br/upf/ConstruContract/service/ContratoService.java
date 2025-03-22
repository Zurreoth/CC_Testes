package br.upf.ConstruContract.service;

import br.upf.ConstruContract.converter.ContratoConverter;
import br.upf.ConstruContract.dto.ContratoDTO;
import br.upf.ConstruContract.model.Contrato;
import br.upf.ConstruContract.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository repository;

    @Autowired
    private ContratanteService contratanteService;

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private ContratoConverter converter;

    public List<Contrato> getContratos() {
        return this.repository.findAll();
    }

    public void cadastrarContrato(ContratoDTO contrato) {
        this.repository.save(this.converter.toContrato(contrato));
    }

    public void excluirContrato(Long id) {

        boolean exists = this.repository.existsById(id);

        if(!exists) {
            throw new IllegalStateException(String.format("Contrato de id %d inexistente", id));
        }

        this.repository.deleteById(id);
    }

    public void editarContrato(Long id, ContratoDTO contratoDTO) {

        Contrato contrato = this.repository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Contrato de id %d inexistente", id)));

        Contrato contratoNovo = this.converter.toContrato(contratoDTO);
        contratoNovo.setId(id);

        this.repository.save(contratoNovo);
    }

    public Contrato getById(Long id) {
        return this.repository.getReferenceById(id);
    }
}

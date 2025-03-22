package br.upf.ConstruContract.converter;

import br.upf.ConstruContract.dto.ContratoDTO;
import br.upf.ConstruContract.model.Contrato;
import br.upf.ConstruContract.model.Projeto;
import br.upf.ConstruContract.model.ProjetoContrato;
import br.upf.ConstruContract.repository.VendedorRepository;
import br.upf.ConstruContract.service.ContratanteService;
import br.upf.ConstruContract.service.ProjetoService;
import br.upf.ConstruContract.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContratoConverter {

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private ContratanteService contratanteService;

    @Autowired
    private ProjetoService projetoService;

    public Contrato toContrato(ContratoDTO dto) {

        List<ProjetoContrato> projetoContratos = new ArrayList<>();
        Contrato contrato = new Contrato(dto.getDataEmissao(),
                                        dto.getValor(),
                                        dto.getStatus(),
                                        contratanteService.getById(dto.getContratante().getId()),
                                        vendedorService.getById(dto.getVendedor().getId()));

        for (Projeto projeto : dto.getProjetos()) {
            projetoContratos.add(new ProjetoContrato(projetoService.getById(projeto.getId()), contrato));
        }

        contrato.setProjetos(projetoContratos);
        return contrato;
    }
}

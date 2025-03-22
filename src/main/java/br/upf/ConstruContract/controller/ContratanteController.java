package br.upf.ConstruContract.controller;

import br.upf.ConstruContract.dto.ContratanteDTO;
import br.upf.ConstruContract.model.Contratante;
import br.upf.ConstruContract.service.ContratanteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "contratante")
@CrossOrigin
public class ContratanteController {

    @Autowired
    private ContratanteService contratanteService;

    @GetMapping
    public List<Contratante> getContratantes() {
        return this.contratanteService.getContratantes();
    }

    @PostMapping
    public void cadastrarContratante(@RequestBody ContratanteDTO contratante) {
        this.contratanteService.cadastrarContratante(contratante);
    }

    @DeleteMapping(path = "{contratanteId}")
    public void excluirContratante(@PathVariable("contratanteId") Long id) {
        this.contratanteService.excluirContratante(id);
    }

    @PutMapping(path = "{contratanteId}")
    @Transactional
    public void editarContratante(@PathVariable("contratanteId") Long id,
                              @RequestBody ContratanteDTO contratanteDTO) {
        this.contratanteService.editarContratante(id, contratanteDTO);
    }

}

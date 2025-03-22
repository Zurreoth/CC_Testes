package br.upf.ConstruContract.controller;

import br.upf.ConstruContract.dto.ProjetoDTO;
import br.upf.ConstruContract.model.Projeto;
import br.upf.ConstruContract.service.ProjetoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "projeto")
@CrossOrigin
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Projeto> getProjetos() {
        return this.projetoService.getProjetos();
    }

    @PostMapping
    public void cadastrarProjeto(@RequestBody ProjetoDTO projeto) {
        this.projetoService.cadastrarProjeto(projeto);
    }

    @DeleteMapping(path = "{projetoId}")
    public void excluirProjeto(@PathVariable("projetoId") Long id) {
        this.projetoService.excluirProjeto(id);
    }

    @PutMapping(path = "{projetoId}")
    @Transactional
    public void editarProjeto(@PathVariable("projetoId") Long id,
                              @RequestBody ProjetoDTO projetoDTO) {
        this.projetoService.editarProjeto(id, projetoDTO);
    }
}

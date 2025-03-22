package br.upf.ConstruContract.controller;

import br.upf.ConstruContract.dto.ContratoDTO;
import br.upf.ConstruContract.model.Contrato;
import br.upf.ConstruContract.service.ContratoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "contrato")
@CrossOrigin
public class ContratoController {
    
    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<Contrato> getContratoes() {
        return this.contratoService.getContratos();
    }

    @PostMapping
    public void cadastrarContrato(@RequestBody ContratoDTO contrato) {
        this.contratoService.cadastrarContrato(contrato);
    }

    @DeleteMapping(path = "{contratoId}")
    public void excluirContrato(@PathVariable("contratoId") Long id) {
        this.contratoService.excluirContrato(id);
    }

    @PutMapping(path = "{contratoId}")
    @Transactional
    public void editarContrato(@PathVariable("contratoId") Long id,
                              @RequestBody ContratoDTO contratoDTO) {
        this.contratoService.editarContrato(id, contratoDTO);
    }
}

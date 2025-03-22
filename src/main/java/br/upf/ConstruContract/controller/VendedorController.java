package br.upf.ConstruContract.controller;

import br.upf.ConstruContract.dto.VendedorDTO;
import br.upf.ConstruContract.model.Vendedor;
import br.upf.ConstruContract.service.VendedorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "vendedor")
@CrossOrigin
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public List<Vendedor> getVendedores() {
        return this.vendedorService.getVendedores();
    }

    @PostMapping
    public void cadastrarVendedor(@RequestBody VendedorDTO vendedor) {
        this.vendedorService.cadastrarVendedor(vendedor);
    }

    @DeleteMapping(path = "{vendedorId}")
    public void excluirVendedor(@PathVariable("vendedorId") Long id) {
        this.vendedorService.excluirVendedor(id);
    }

    @PutMapping(path = "{vendedorId}")
    @Transactional
    public void editarVendedor(@PathVariable("vendedorId") Long id,
                              @RequestBody VendedorDTO vendedorDTO) {
        this.vendedorService.editarVendedor(id, vendedorDTO);
    }
    
}

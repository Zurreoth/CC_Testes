package br.upf.ConstruContract.controller;

import br.upf.ConstruContract.dto.UsuarioDTO;
import br.upf.ConstruContract.model.Usuario;
import br.upf.ConstruContract.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios() {
       return this.usuarioService.getUsuarios();
    }

    @PostMapping
    public void cadastrarUsuario(@RequestBody Usuario usuario) {
        this.usuarioService.cadastrarUsuario(usuario);
    }

    @DeleteMapping(path = "{usuarioId}")
    public void excluirUsuario(@PathVariable("usuarioId") Long id) {
        this.usuarioService.excluirUsuario(id);
    }

    @PutMapping(path = "{usuarioId}")
    @Transactional
    public void editarUsuario(@PathVariable("usuarioId") Long id,
                              @RequestBody UsuarioDTO usuarioDto) {
        this.usuarioService.editarUsuario(id, usuarioDto);
    }

    @PostMapping(path = "/login")
    public boolean login(@RequestBody UsuarioDTO usuarioDto) {
        return this.usuarioService.login(usuarioDto);
    }

}

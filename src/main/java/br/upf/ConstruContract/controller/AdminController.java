package br.upf.ConstruContract.controller;

import br.upf.ConstruContract.dto.AdminDTO;
import br.upf.ConstruContract.model.Admin;
import br.upf.ConstruContract.service.AdminService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAdmins() {
        return this.adminService.getAdmins();
    }

    @PostMapping
    public void cadastrarAdmin(@RequestBody AdminDTO admin) {
        this.adminService.cadastrarAdmin(admin);
    }

    @DeleteMapping(path = "{adminId}")
    public void excluirAdmin(@PathVariable("adminId") Long id) {
        this.adminService.excluirAdmin(id);
    }

    @PutMapping(path = "{adminId}")
    @Transactional
    public void editarAdmin(@PathVariable("adminId") Long id,
                              @RequestBody AdminDTO adminDTO) {
        this.adminService.editarAdmin(id, adminDTO);
    }
    
}

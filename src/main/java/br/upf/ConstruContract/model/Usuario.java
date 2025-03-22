package br.upf.ConstruContract.model;

import jakarta.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @SequenceGenerator(name = "SEQUsuario", sequenceName = "SEQUsuario", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUsuario")
    private Long id;
    private String senha;
    private String email;

    public Usuario() {
    }

    public Usuario(Long id, String senha, String email) {
        this.id = id;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(String senha, String email) {
        this.senha = senha;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package br.upf.ConstruContract.model;

import jakarta.persistence.*;

@Entity
@Table
public class Admin {

    @Id
    @SequenceGenerator(name = "SEQAdmin", sequenceName = "SEQAdmin", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQAdmin")
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Admin() {}

    public Admin(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

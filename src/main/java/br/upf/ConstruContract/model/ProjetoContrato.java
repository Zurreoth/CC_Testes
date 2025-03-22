package br.upf.ConstruContract.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table
public class ProjetoContrato {

    @Id
    @SequenceGenerator(name = "SEQProjetoContrato", sequenceName = "SEQProjetoContrato", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQProjetoContrato")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    public ProjetoContrato() {
    }

    public ProjetoContrato(Projeto projeto, Contrato contrato) {
        this.projeto = projeto;
        this.contrato = contrato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}

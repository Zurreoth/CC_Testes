package br.upf.ConstruContract.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Projeto {

    @Id
    @SequenceGenerator(name = "SEQProjeto", sequenceName = "SEQProjeto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQProjeto")
    private Long id;

    private String nome;
    private Double valor;

    @JsonManagedReference
    @OneToMany(mappedBy = "projeto", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ImagemProjeto> imagens;

    public Projeto() {
    }

    public Projeto(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<ImagemProjeto> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemProjeto> imagens) {
        this.imagens = imagens;
    }
}

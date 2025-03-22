package br.upf.ConstruContract.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table
public class ImagemProjeto {

    @Id
    @SequenceGenerator(name = "SEQImagemProjeto", sequenceName = "SEQImagemProjeto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQImagemProjeto")
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    private byte[] imagem;

    public ImagemProjeto() {
    }

    public ImagemProjeto(byte[] imagem, Projeto projeto) {
        this.imagem = imagem;
        this.projeto = projeto;
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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}

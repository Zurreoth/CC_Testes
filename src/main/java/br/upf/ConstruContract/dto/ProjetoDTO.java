package br.upf.ConstruContract.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProjetoDTO {

    private String nome;
    private Double valor;
    private List<byte[]> imagens;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjetoDTO that = (ProjetoDTO) o;
        return Objects.equals(nome, that.nome) && Objects.equals(valor, that.valor) && Objects.equals(imagens, that.imagens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, valor, imagens);
    }

    public ProjetoDTO() {

    }

    public ProjetoDTO(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
        this.imagens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public List<byte[]> getImagens() {
        return imagens;
    }
}

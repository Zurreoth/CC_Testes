package br.upf.ConstruContract.dto;

import br.upf.ConstruContract.model.Contratante;
import br.upf.ConstruContract.model.Projeto;
import br.upf.ConstruContract.model.Vendedor;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ContratoDTO {
    private Date dataEmissao;
    private Double valor;
    private Integer status;
    private Contratante contratante;
    private Vendedor vendedor;
    private List<Projeto> projetos;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContratoDTO that = (ContratoDTO) o;
        return Objects.equals(dataEmissao, that.dataEmissao) && Objects.equals(valor, that.valor) && Objects.equals(status, that.status) && Objects.equals(contratante, that.contratante) && Objects.equals(vendedor, that.vendedor) && Objects.equals(projetos, that.projetos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataEmissao, valor, status, contratante, vendedor, projetos);
    }

    public ContratoDTO() {

    }

    public ContratoDTO(Date dataEmissao, Double valor, Integer status, Contratante contratante, Vendedor vendedor) {
        this.dataEmissao = dataEmissao;
        this.valor = valor;
        this.status = status;
        this.contratante = contratante;
        this.vendedor = vendedor;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getStatus() {
        return status;
    }

    public Contratante getContratante() {
        return contratante;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }
}

package br.upf.ConstruContract.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Contrato {

    @Id
    @SequenceGenerator(name = "SEQContrato", sequenceName = "SEQContrato", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQContrato")
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataEmissao;

    private Double valor;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "contratante_id")
    private Contratante contratante;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @JsonManagedReference
    @OneToMany(mappedBy = "contrato", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ProjetoContrato> projetos;

    public Contrato() {
    }

    public Contrato(Date dataEmissao, Contratante contratante, Vendedor vendedor) {
        this.dataEmissao = dataEmissao;
        this.contratante = contratante;
        this.vendedor = vendedor;
    }

    public Contrato(Date dataEmissao, Double valor, Integer status, Contratante contratante, Vendedor vendedor) {
        this.dataEmissao = dataEmissao;
        this.valor = valor;
        this.status = status;
        this.contratante = contratante;
        this.vendedor = vendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Contratante getContratante() {
        return contratante;
    }

    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<ProjetoContrato> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<ProjetoContrato> projetos) {
        this.projetos = projetos;
    }
}

package com.unitri.ppi.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.unitri.ppi.domain.*;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

public class MultaRepresentation extends ResourceSupport {

    @JsonInclude(Include.NON_NULL)
    private Integer idMulta;

    @JsonInclude(Include.NON_NULL)
    private String descricao;

    @JsonInclude(Include.NON_NULL)
    private double valor;

    @JsonIgnore
    private List<Locacao> locacaoList;

    @JsonInclude(Include.NON_NULL)
    private Veiculo idVeiculo;

    public MultaRepresentation() {
    }

    public MultaRepresentation(Integer idMulta, String descricao, double valor, List<Locacao> locacaoList, Veiculo idVeiculo) {
        this.idMulta = idMulta;
        this.descricao = descricao;
        this.valor = valor;
        this.locacaoList = locacaoList;
        this.idVeiculo = idVeiculo;
    }

    public MultaRepresentation(Multa multa) {
        this.idMulta = multa.getIdMulta();
        this.descricao = multa.getDescricao();
        this.valor = multa.getValor();
        this.locacaoList = multa.getLocacaoList();
        this.idVeiculo = multa.getIdVeiculo();
    }

    public static Multa build (MultaRepresentation representation){
        Multa multa = new Multa();

        multa.setIdMulta(representation.getIdMulta());
        multa.setDescricao(representation.getDescricao());
        multa.setValor(representation.getValor());
        multa.setLocacaoList(representation.getLocacaoList());
        multa.setIdVeiculo(multa.getIdVeiculo());

        return multa;
    }

    public Integer getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(Integer idMulta) {
        this.idMulta = idMulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Locacao> getLocacaoList() {
        return locacaoList;
    }

    public void setLocacaoList(List<Locacao> locacaoList) {
        this.locacaoList = locacaoList;
    }

    public Veiculo getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Veiculo idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
}

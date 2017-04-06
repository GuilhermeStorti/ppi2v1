package com.unitri.ppi.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.unitri.ppi.domain.*;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

public class LocacaoRepresentation extends ResourceSupport {

    @JsonInclude(Include.NON_NULL)
    private Integer idLocacao;

    @JsonInclude
    private Date dataLocacao;

    @JsonInclude
    private List<Avaria> avariaList;

    @JsonInclude
    private List<Multa> multaList;

    @JsonInclude(Include.NON_NULL)
    private Cliente idCliente;

    @JsonInclude(Include.NON_NULL)
    private Funcionario idFuncionariocad;

    @JsonInclude
    private Funcionario idFuncionariorec;

    @JsonInclude(Include.NON_NULL)
    private Veiculo idVeiculo;

    public LocacaoRepresentation() {
    }

    public LocacaoRepresentation(Integer idLocacao, Date dataLocacao, List<Avaria> avariaList, List<Multa> multaList, Cliente idCliente, Funcionario idFuncionariocad, Funcionario idFuncionariorec, Veiculo idVeiculo) {
        this.idLocacao = idLocacao;
        this.dataLocacao = dataLocacao;
        this.avariaList = avariaList;
        this.multaList = multaList;
        this.idCliente = idCliente;
        this.idFuncionariocad = idFuncionariocad;
        this.idFuncionariorec = idFuncionariorec;
        this.idVeiculo = idVeiculo;
    }

    public LocacaoRepresentation(Locacao locacao) {
        this.idLocacao = locacao.getIdLocacao();
        this.dataLocacao = locacao.getDataLocacao();
        this.avariaList = locacao.getAvariaList();
        this.multaList = locacao.getMultaList();
        this.idCliente = locacao.getIdCliente();
        this.idFuncionariocad = locacao.getIdFuncionariocad();
        this.idFuncionariorec = locacao.getIdFuncionariorec();
        this.idVeiculo = locacao.getIdVeiculo();
    }

    public static Locacao build (LocacaoRepresentation representation){
        Locacao locacao = new Locacao();

        locacao.setIdLocacao(representation.getIdLocacao());
        locacao.setDataLocacao(representation.getDataLocacao());
        locacao.setAvariaList(representation.getAvariaList());
        locacao.setMultaList(representation.getMultaList());
        locacao.setIdCliente(representation.getIdCliente());
        locacao.setIdFuncionariocad(representation.getIdFuncionariocad());
        locacao.setIdFuncionariorec(locacao.getIdFuncionariorec());
        locacao.setIdVeiculo(locacao.getIdVeiculo());

        return locacao;
    }

    public Integer getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(Integer idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public List<Avaria> getAvariaList() {
        return avariaList;
    }

    public void setAvariaList(List<Avaria> avariaList) {
        this.avariaList = avariaList;
    }

    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Funcionario getIdFuncionariocad() {
        return idFuncionariocad;
    }

    public void setIdFuncionariocad(Funcionario idFuncionariocad) {
        this.idFuncionariocad = idFuncionariocad;
    }

    public Funcionario getIdFuncionariorec() {
        return idFuncionariorec;
    }

    public void setIdFuncionariorec(Funcionario idFuncionariorec) {
        this.idFuncionariorec = idFuncionariorec;
    }

    public Veiculo getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Veiculo idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
}

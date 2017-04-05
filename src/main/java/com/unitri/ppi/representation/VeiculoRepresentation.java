package com.unitri.ppi.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.unitri.ppi.domain.Categoria;
import com.unitri.ppi.domain.Locacao;
import com.unitri.ppi.domain.Multa;
import com.unitri.ppi.domain.Veiculo;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class VeiculoRepresentation extends ResourceSupport {

    @JsonInclude(Include.NON_NULL)
    private Integer idVeiculo;

    @JsonInclude(Include.NON_NULL)
    private String marca;

    @JsonInclude(Include.NON_NULL)
    private String placa;

    @JsonInclude(Include.NON_NULL)
    private String modelo;

    @JsonInclude
    private Categoria idCategoria;

    @JsonInclude
    private List<Multa> multaList;

    @JsonInclude
    private List<Locacao> locacaoList;

    public VeiculoRepresentation() {
    }

    public VeiculoRepresentation(Integer idVeiculo, String marca, String placa, String modelo, Categoria idCategoria, List<Multa> multaList, List<Locacao> locacaoList) {
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.placa = placa;
        this.modelo = modelo;
        this.idCategoria = idCategoria;
        this.multaList = multaList;
        this.locacaoList = locacaoList;
    }

    public VeiculoRepresentation(Veiculo veiculo) {
        this.idVeiculo = veiculo.getIdVeiculo();
        this.marca = veiculo.getMarca();
        this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
        this.idCategoria = veiculo.getIdCategoria();
        this.multaList = veiculo.getMultaList();
        this.locacaoList = veiculo.getLocacaoList();
    }

    public static Veiculo build (VeiculoRepresentation representation){
        Veiculo veiculo = new Veiculo();

        veiculo.setIdVeiculo(representation.getIdVeiculo());
        veiculo.setMarca(representation.getMarca());
        veiculo.setPlaca(representation.getPlaca());
        veiculo.setModelo(representation.getModelo());
        veiculo.setIdCategoria(representation.getIdCategoria());
        veiculo.setMultaList(veiculo.getMultaList());
        veiculo.setLocacaoList(representation.getLocacaoList());

        return veiculo;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    public List<Locacao> getLocacaoList() {
        return locacaoList;
    }

    public void setLocacaoList(List<Locacao> locacaoList) {
        this.locacaoList = locacaoList;
    }
}

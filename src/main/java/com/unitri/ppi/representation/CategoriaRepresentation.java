package com.unitri.ppi.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.unitri.ppi.domain.Categoria;
import com.unitri.ppi.domain.Locacao;
import com.unitri.ppi.domain.Veiculo;
import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;
import java.util.List;

public class CategoriaRepresentation extends ResourceSupport {

    @JsonInclude(Include.NON_NULL)
    private Integer idCategoria;

    @JsonInclude(Include.NON_NULL)
    private BigDecimal preco;

    @JsonInclude(Include.NON_NULL)
    private String descricao;

    @JsonIgnore
    private List<Veiculo> veiculoList;

    public CategoriaRepresentation() {
    }

    public CategoriaRepresentation(Integer idCategoria, BigDecimal preco, String descricao) {
        this.idCategoria = idCategoria;
        this.preco = preco;
        this.descricao = descricao;
    }

    public CategoriaRepresentation(Categoria categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.preco = categoria.getPreco();
        this.descricao = categoria.getDescricao();
    }

    public static Categoria build (CategoriaRepresentation representation){
        Categoria categoria = new Categoria();

        categoria.setIdCategoria(representation.getIdCategoria());
        categoria.setPreco(representation.getPreco());
        categoria.setDescricao(representation.getDescricao());
        categoria.setVeiculoList(representation.getVeiculoList());

        return categoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    public void setVeiculoList(List<Veiculo> veiculoList) {
        this.veiculoList = veiculoList;
    }
}

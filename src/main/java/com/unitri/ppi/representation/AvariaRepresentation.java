package com.unitri.ppi.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.unitri.ppi.domain.Avaria;
import com.unitri.ppi.domain.Locacao;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class AvariaRepresentation extends ResourceSupport {

    @JsonInclude(Include.NON_NULL)
    private Integer idAvaria;
    
    @JsonInclude(Include.NON_NULL)
    private String descricao;

    @JsonIgnore
    private List<Locacao> locacaoList;

    public AvariaRepresentation() {
    }

    public AvariaRepresentation(Integer idAvaria, String descricao, List<Locacao> locacaoList) {
        this.idAvaria = idAvaria;
        this.descricao = descricao;
        this.locacaoList = locacaoList;
    }

    public AvariaRepresentation(Avaria avaria) {
        this.idAvaria = avaria.getIdAvaria();
        this.descricao = avaria.getDescricao();
        this.locacaoList = avaria.getLocacaoList();
    }

    public static Avaria build(AvariaRepresentation representation){
        Avaria avaria = new Avaria();

        avaria.setIdAvaria(representation.getIdAvaria());
        avaria.setDescricao(representation.getDescricao());
        avaria.setLocacaoList(representation.getLocacaoList());

        return avaria;
    }

    public Integer getIdAvaria() {
        return idAvaria;
    }

    public void setIdAvaria(Integer idAvaria) {
        this.idAvaria = idAvaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Locacao> getLocacaoList() {
        return locacaoList;
    }

    public void setLocacaoList(List<Locacao> locacaoList) {
        this.locacaoList = locacaoList;
    }
}

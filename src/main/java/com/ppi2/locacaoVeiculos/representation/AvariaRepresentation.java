package com.ppi2.locacaoVeiculos.representation;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.locacaoVeiculos.domain.Avaria;

public class AvariaRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal valor;
	
	public AvariaRepresentation() {
	}
	
	public AvariaRepresentation(Avaria avaria) {
		this.identifier = avaria.getId();
		this.descricao = avaria.getDescricao();
		this.valor = avaria.getValor();
	}
	
	public static Avaria build(AvariaRepresentation representation) {
		
		Avaria avaria = new Avaria();
		avaria.setId(representation.getIdentifier());
		avaria.setDescricao(representation.getDescricao());
		avaria.setValor(representation.getValor());
		
		return avaria;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}

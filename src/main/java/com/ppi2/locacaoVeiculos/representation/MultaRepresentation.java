package com.ppi2.locacaoVeiculos.representation;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.locacaoVeiculos.domain.Multa;

public class MultaRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal valor;
	
	public MultaRepresentation() {
	}
	
	public MultaRepresentation(Multa multa) {
		this.identifier = multa.getId();
		this.descricao = multa.getDescricao();
		this.valor = multa.getValor();
	}
	
	public static Multa build(MultaRepresentation representation) {
		
		Multa multa = new Multa();
		multa.setId(representation.getIdentifier());
		multa.setDescricao(representation.getDescricao());
		multa.setValor(representation.getValor());
		
		return multa;
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

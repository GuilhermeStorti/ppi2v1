package com.ppi2.locacaoVeiculos.representation;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.locacaoVeiculos.domain.Categoria;
import com.ppi2.locacaoVeiculos.domain.Veiculo;

public class VeiculoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	
	@JsonInclude(Include.NON_NULL)
	private Integer ano;
	
	@JsonInclude(Include.NON_NULL)
	private String marca;
	
	@JsonInclude(Include.NON_NULL)
	private String modelo;
	
	@JsonInclude(Include.NON_NULL)
	private String observacao;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal valor;
	
	@JsonInclude(Include.NON_NULL)
	private CategoriaRepresentation categoriaRepresentation;
	
	public VeiculoRepresentation() {
	}
	
	public VeiculoRepresentation(Veiculo veiculo) {
		this.identifier = veiculo.getId();
		this.ano = veiculo.getAno();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.observacao = veiculo.getObservacao();
		this.valor = veiculo.getValor();
		
		if (veiculo.getCategoria() != null) {
			Categoria categoria = veiculo.getCategoria();
			CategoriaRepresentation categoriaRepresentation = new CategoriaRepresentation(categoria);
			this.setCategoriaRepresentation(categoriaRepresentation);
		}
	}
	
	public static Veiculo build(VeiculoRepresentation representation) {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setId(representation.getIdentifier());
		veiculo.setAno(representation.getAno());
		veiculo.setMarca(representation.getMarca());
		veiculo.setModelo(representation.getModelo());
		veiculo.setObservacao(representation.getObservacao());
		veiculo.setValor(representation.getValor());
		
		if (representation.getCategoriaRepresentation() != null) {
			veiculo.setCategoria(CategoriaRepresentation.build(representation.getCategoriaRepresentation()));
		}		
		
		return veiculo;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public CategoriaRepresentation getCategoriaRepresentation() {
		return categoriaRepresentation;
	}
	
	public void setCategoriaRepresentation(CategoriaRepresentation categoriaRepresentation) {
		this.categoriaRepresentation = categoriaRepresentation;
	}
	
}

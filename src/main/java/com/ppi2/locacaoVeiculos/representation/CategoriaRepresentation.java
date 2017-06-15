package com.ppi2.locacaoVeiculos.representation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.locacaoVeiculos.domain.Categoria;

public class CategoriaRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal preco;
	
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	
	private List<VeiculoRepresentation> veiculoRepresentations;
	
	public CategoriaRepresentation() {
	}
	
	public CategoriaRepresentation(Categoria categoria) {
		this.identifier = categoria.getId();
		this.preco = categoria.getPreco();
		this.descricao = categoria.getDescricao();
		
		/*if (categoria.getVeiculos() != null) {
			this.setVeiculoRepresentations(new ArrayList<>());
			categoria.getVeiculos().forEach(veiculo -> {
				veiculo.setCategoria(null);
				this.getVeiculoRepresentations().add(new VeiculoRepresentation(veiculo));
			});
		}*/
	}
	
	public static Categoria build(CategoriaRepresentation representation) {
		
		Categoria categoria = new Categoria();
		categoria.setId(representation.getIdentifier());
		categoria.setPreco(representation.getPreco());
		categoria.setDescricao(representation.getDescricao());
		
		return categoria;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
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
	
	public List<VeiculoRepresentation> getVeiculoRepresentations() {
		return veiculoRepresentations;
	}
	
	public void setVeiculoRepresentations(List<VeiculoRepresentation> veiculoRepresentations) {
		this.veiculoRepresentations = veiculoRepresentations;
	}
	
}

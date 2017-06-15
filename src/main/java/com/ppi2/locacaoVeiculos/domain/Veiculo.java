package com.ppi2.locacaoVeiculos.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the veiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Veiculo.findAll", query="SELECT v FROM Veiculo v")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer ano;

	private String marca;

	private String modelo;

	private String observacao;

	private BigDecimal valor;

	//bi-directional many-to-one association to Locacao
	@OneToMany(mappedBy="veiculo")
	private List<Locacao> locacaos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	private Categoria categoria;

	public Veiculo() {
	}
	
	public Veiculo(Long id, int ano, String marca, String modelo, String observacao, BigDecimal valor, Categoria categoria) {
		super();
		this.id = id;
		this.ano = ano;
		this.marca = marca;
		this.modelo = modelo;
		this.observacao = observacao;
		this.valor = valor;
		this.categoria = categoria;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Locacao> getLocacaos() {
		return this.locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

	public Locacao addLocacao(Locacao locacao) {
		getLocacaos().add(locacao);
		locacao.setVeiculo(this);

		return locacao;
	}

	public Locacao removeLocacao(Locacao locacao) {
		getLocacaos().remove(locacao);
		locacao.setVeiculo(null);

		return locacao;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", ano=" + ano + ", marca=" + marca + ", modelo=" + modelo + ", observacao="
				+ observacao + ", valor=" + valor + ", locacaos=" + locacaos + ", categoria=" + categoria + "]";
	}
	
}
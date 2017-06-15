package com.ppi2.locacaoVeiculos.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cpf;

	private String endereco;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to Locacao
	@OneToMany(mappedBy="cliente")
	private List<Locacao> locacaos;

	public Cliente() {
	}
	
	public Cliente(Long id, String cpf, String endereco, String nome, String telefone) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.endereco = endereco;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Locacao> getLocacaos() {
		return this.locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

	public Locacao addLocacao(Locacao locacao) {
		getLocacaos().add(locacao);
		locacao.setCliente(this);

		return locacao;
	}

	public Locacao removeLocacao(Locacao locacao) {
		getLocacaos().remove(locacao);
		locacao.setCliente(null);

		return locacao;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", endereco=" + endereco + ", nome=" + nome + ", telefone="
				+ telefone + ", locacaos=" + locacaos + "]";
	}
	
}
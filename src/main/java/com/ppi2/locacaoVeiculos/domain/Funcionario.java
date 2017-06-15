package com.ppi2.locacaoVeiculos.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String endereco;

	private String matricula;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to Locacao
	@OneToMany(mappedBy="funcionarioCad")
	private List<Locacao> locacoesCad;

	//bi-directional many-to-one association to Locacao
	@OneToMany(mappedBy="funcionarioRec")
	private List<Locacao> locacoesRec;

	public Funcionario() {
	}
	
	public Funcionario(Long id, String endereco, String matricula, String nome, String telefone) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public List<Locacao> getLocacoesCad() {
		return locacoesCad;
	}
	
	public void setLocacoesCad(List<Locacao> locacoesCad) {
		this.locacoesCad = locacoesCad;
	}

	/*public Locacao addLocacaos1(Locacao locacaos1) {
		getLocacaos().add(locacaos1);
		locacaos1.setFuncionarioCad(this);

		return locacaos1;
	}

	public Locacao removeLocacaos1(Locacao locacaos1) {
		getLocacaos1().remove(locacaos1);
		locacaos1.setFuncionarioCad(null);

		return locacaos1;
	}*/

	public List<Locacao> getLocacoesRec() {
		return locacoesRec;
	}
	
	public void setLocacoesRec(List<Locacao> locacoesRec) {
		this.locacoesRec = locacoesRec;
	}

	/*public Locacao addLocacaos2(Locacao locacaos2) {
		getLocacaos2().add(locacaos2);
		locacaos2.setFuncionarioRec(this);

		return locacaos2;
	}

	public Locacao removeLocacaos2(Locacao locacaos2) {
		getLocacaos2().remove(locacaos2);
		locacaos2.setFuncionarioRec(null);

		return locacaos2;
	}*/

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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", endereco=" + endereco + ", matricula=" + matricula + ", nome=" + nome
				+ ", telefone=" + telefone + ", locacaos1=" + locacoesCad + ", locacaos2=" + locacoesRec + "]";
	}
	
}
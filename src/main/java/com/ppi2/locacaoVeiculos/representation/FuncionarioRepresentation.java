package com.ppi2.locacaoVeiculos.representation;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.locacaoVeiculos.domain.Funcionario;

public class FuncionarioRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	
	@JsonInclude(Include.NON_NULL)
	private String endereco;
	
	@JsonInclude(Include.NON_NULL)
	private String matricula;
	
	@JsonInclude(Include.NON_NULL)
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private String telefone;
	
	@JsonInclude(Include.NON_NULL)
	List<LocacaoRepresentation> locacaoRepresentations;
	
	public FuncionarioRepresentation() {
	}
	
	public FuncionarioRepresentation(Funcionario funcionario) {
		this.identifier = funcionario.getId();
		this.endereco = funcionario.getEndereco();
		this.matricula = funcionario.getMatricula();
		this.nome = funcionario.getNome();
		this.telefone = funcionario.getTelefone();
	}
	
	public static Funcionario build(FuncionarioRepresentation representation) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(representation.getIdentifier());
		funcionario.setEndereco(representation.getEndereco());
		funcionario.setMatricula(representation.getMatricula());
		funcionario.setNome(representation.getNome());
		funcionario.setTelefone(representation.getTelefone());
		
		return funcionario;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<LocacaoRepresentation> getLocacaoRepresentations() {
		return locacaoRepresentations;
	}
	
	public void setLocacaoRepresentations(List<LocacaoRepresentation> locacaoRepresentations) {
		this.locacaoRepresentations = locacaoRepresentations;
	}
	
}

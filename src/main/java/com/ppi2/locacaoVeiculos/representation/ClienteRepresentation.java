package com.ppi2.locacaoVeiculos.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.locacaoVeiculos.domain.Cliente;

public class ClienteRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	
	@JsonInclude(Include.NON_NULL)
	private String cpf;
	
	@JsonInclude(Include.NON_NULL)
	private String endereco;
	
	@JsonInclude(Include.NON_NULL)
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private String telefone;
	
	public ClienteRepresentation() {
	}
	
	public ClienteRepresentation(Cliente cliente) {
		this.identifier = cliente.getId();
		this.cpf = cliente.getCpf();
		this.endereco = cliente.getEndereco();
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
	}
	
	public static Cliente build(ClienteRepresentation representation) {

		Cliente cliente = new Cliente();
		cliente.setId(representation.getIdentifier());
		cliente.setCpf(representation.getCpf());
		cliente.setEndereco(representation.getEndereco());
		cliente.setNome(representation.getNome());
		cliente.setTelefone(representation.getTelefone());
		
		return cliente;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	
}

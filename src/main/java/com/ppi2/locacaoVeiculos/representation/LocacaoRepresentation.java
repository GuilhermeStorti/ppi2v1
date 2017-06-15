package com.ppi2.locacaoVeiculos.representation;

import java.sql.Time;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.locacaoVeiculos.domain.Cliente;
import com.ppi2.locacaoVeiculos.domain.Funcionario;
import com.ppi2.locacaoVeiculos.domain.Locacao;
import com.ppi2.locacaoVeiculos.domain.Veiculo;

public class LocacaoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	
	@JsonInclude(Include.NON_NULL)
	private Date data;
	
	@JsonInclude(Include.NON_NULL)
	private Time hora;
	
	@JsonInclude(Include.NON_NULL)
	private ClienteRepresentation clienteRepresentation;
	
	@JsonInclude(Include.NON_NULL)
	private FuncionarioRepresentation funcionarioRepresentationCad;
	
	@JsonInclude(Include.NON_NULL)
	private FuncionarioRepresentation funcionarioRepresentationRec;
	
	@JsonInclude(Include.NON_NULL)
	private VeiculoRepresentation veiculoRepresentation;
	
	public LocacaoRepresentation() {
	}
	
	public LocacaoRepresentation(Locacao locacao) {
		this.identifier = locacao.getId();
		this.data = locacao.getData();
		this.hora = locacao.getHora();
		
		if (locacao.getCliente() != null) {
			Cliente cliente = locacao.getCliente();
			ClienteRepresentation clienteRepresentation = new ClienteRepresentation(cliente);
			this.setClienteRepresentation(clienteRepresentation);
		}
		
		if (locacao.getFuncionarioCad() != null) {
			Funcionario funcionario = locacao.getFuncionarioCad();
			FuncionarioRepresentation funcionarioRepresentation = new FuncionarioRepresentation(funcionario);
			this.setFuncionarioRepresentationCad(funcionarioRepresentation);
		}
		
		if (locacao.getFuncionarioRec() != null) {
			Funcionario funcionario = locacao.getFuncionarioRec();
			FuncionarioRepresentation funcionarioRepresentation = new FuncionarioRepresentation(funcionario);
			this.setFuncionarioRepresentationRec(funcionarioRepresentation);
		}
		
		if (locacao.getVeiculo() != null) {
			Veiculo veiculo = locacao.getVeiculo();
			VeiculoRepresentation veiculoRepresentation = new VeiculoRepresentation(veiculo);
			this.setVeiculoRepresentation(veiculoRepresentation);
		}
	}
	
	public static Locacao build(LocacaoRepresentation representation) {
		
		Locacao locacao = new Locacao();
		locacao.setId(representation.getIdentifier());
		locacao.setData(representation.getData());
		locacao.setHora(representation.getHora());
		
		if (representation.getClienteRepresentation() != null) {
			locacao.setCliente(ClienteRepresentation.build(representation.getClienteRepresentation()));
		}
		
		if (representation.getFuncionarioRepresentationCad() != null) {
			locacao.setFuncionarioCad(FuncionarioRepresentation.build(representation.getFuncionarioRepresentationCad()));
		}
	
		if (representation.getFuncionarioRepresentationRec() != null) {
			locacao.setFuncionarioRec(FuncionarioRepresentation.build(representation.getFuncionarioRepresentationRec()));
		}

		if (representation.getVeiculoRepresentation() != null) {
			locacao.setVeiculo(VeiculoRepresentation.build(representation.getVeiculoRepresentation()));
		}
		
		return locacao;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public ClienteRepresentation getClienteRepresentation() {
		return clienteRepresentation;
	}

	public void setClienteRepresentation(ClienteRepresentation clienteRepresentation) {
		this.clienteRepresentation = clienteRepresentation;
	}

	public FuncionarioRepresentation getFuncionarioRepresentationCad() {
		return funcionarioRepresentationCad;
	}

	public void setFuncionarioRepresentationCad(FuncionarioRepresentation funcionarioRepresentationCad) {
		this.funcionarioRepresentationCad = funcionarioRepresentationCad;
	}

	public FuncionarioRepresentation getFuncionarioRepresentationRec() {
		return funcionarioRepresentationRec;
	}

	public void setFuncionarioRepresentationRec(FuncionarioRepresentation funcionarioRepresentationRec) {
		this.funcionarioRepresentationRec = funcionarioRepresentationRec;
	}

	public VeiculoRepresentation getVeiculoRepresentation() {
		return veiculoRepresentation;
	}

	public void setVeiculoRepresentation(VeiculoRepresentation veiculoRepresentation) {
		this.veiculoRepresentation = veiculoRepresentation;
	}
	
}

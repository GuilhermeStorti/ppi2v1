package com.ppi2.locacaoVeiculos.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the locacao database table.
 * 
 */
@Entity
@NamedQuery(name="Locacao.findAll", query="SELECT l FROM Locacao l")
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date data;

	private Time hora;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="funcionario_id_cad")
	private Funcionario funcionarioCad;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="funcionario_id_rec")
	private Funcionario funcionarioRec;

	//bi-directional many-to-one association to Veiculo
	@ManyToOne
	private Veiculo veiculo;

	//bi-directional many-to-many association to Avaria
	@ManyToMany
	@JoinTable(
		name="locacao_avaria"
		, joinColumns={
			@JoinColumn(name="locacao_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="avaria_id")
			}
		)
	private List<Avaria> avarias;

	//bi-directional many-to-many association to Multa
	@ManyToMany
	@JoinTable(
		name="locacao_multa"
		, joinColumns={
			@JoinColumn(name="locacao_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="multa_id")
			}
		)
	private List<Multa> multas;

	public Locacao() {
	}
	
	public Locacao(Long id, Date data, Time hora, Cliente cliente, Funcionario funcionarioCad, Funcionario funcionarioRec,
			Veiculo veiculo) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.cliente = cliente;
		this.funcionarioCad = funcionarioCad;
		this.funcionarioRec = funcionarioRec;
		this.veiculo = veiculo;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionarioCad() {
		return funcionarioCad;
	}
	
	public void setFuncionarioCad(Funcionario funcionarioCad) {
		this.funcionarioCad = funcionarioCad;
	}
	
	public Funcionario getFuncionarioRec() {
		return funcionarioRec;
	}
	
	public void setFuncionarioRec(Funcionario funcionarioRec) {
		this.funcionarioRec = funcionarioRec;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Avaria> getAvarias() {
		return this.avarias;
	}

	public void setAvarias(List<Avaria> avarias) {
		this.avarias = avarias;
	}

	public List<Multa> getMultas() {
		return this.multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
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
		Locacao other = (Locacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Locacao [id=" + id + ", data=" + data + ", hora=" + hora + ", cliente=" + cliente + ", funcionarioCad="
				+ funcionarioCad + ", funcionarioRec=" + funcionarioRec + ", veiculo=" + veiculo + ", avarias=" + avarias
				+ ", multas=" + multas + "]";
	}
	
}
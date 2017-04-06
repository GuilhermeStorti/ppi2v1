package com.unitri.ppi.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.unitri.ppi.domain.Cliente;
import com.unitri.ppi.domain.Locacao;
import com.unitri.ppi.domain.Veiculo;
import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;
import java.util.List;

public class ClienteRepresentation extends ResourceSupport {

    @JsonInclude(Include.NON_NULL)
    private Integer idCliente;

    @JsonInclude(Include.NON_NULL)
    private String nome;

    @JsonInclude
    private String telefone;

    @JsonInclude
    private String cpf;
    @JsonInclude
    private String cnh;

    @JsonInclude(Include.NON_NULL)
    private Character situacao;

    @JsonIgnore
    private List<Locacao> locacaoList;

    public ClienteRepresentation() {
    }

    public ClienteRepresentation(Integer idCliente, String nome, String telefone, String cpf, String cnh, Character situacao, List<Locacao> locacaoList) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cnh = cnh;
        this.situacao = situacao;
        this.locacaoList = locacaoList;
    }

    public ClienteRepresentation(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.cnh = cliente.getCnh();
        this.situacao = cliente.getSituacao();
        this.locacaoList = cliente.getLocacaoList();
    }

    public static Cliente build (ClienteRepresentation representation){
        Cliente cliente = new Cliente();

        cliente.setIdCliente(representation.getIdCliente());
        cliente.setNome(representation.getNome());
        cliente.setTelefone(representation.getTelefone());
        cliente.setCpf(representation.getCpf());
        cliente.setCnh(representation.getCnh());
        cliente.setSituacao(representation.getSituacao());
        cliente.setLocacaoList(representation.getLocacaoList());

        return cliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public List<Locacao> getLocacaoList() {
        return locacaoList;
    }

    public void setLocacaoList(List<Locacao> locacaoList) {
        this.locacaoList = locacaoList;
    }
}

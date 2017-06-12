package com.unitri.ppi.domain;

import javax.persistence.*;

/**
 * Created by guilhermeplasma on 12/06/17.
 */
@Entity
@Table(name = "cliente", schema = "locacao", catalog = "")
public class Cliente {
    private int idCliente;
    private String cnh;
    private String cpf;
    private String nome;
    private String situacao;
    private String telefone;

    @Id
    @Column(name = "id_cliente")
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "cnh")
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Basic
    @Column(name = "cpf")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "situacao")
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Basic
    @Column(name = "telefone")
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente that = (Cliente) o;

        if (idCliente != that.idCliente) return false;
        if (cnh != null ? !cnh.equals(that.cnh) : that.cnh != null) return false;
        if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (situacao != null ? !situacao.equals(that.situacao) : that.situacao != null) return false;
        if (telefone != null ? !telefone.equals(that.telefone) : that.telefone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (cnh != null ? cnh.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (situacao != null ? situacao.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        return result;
    }
}

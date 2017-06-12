package com.unitri.ppi.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by guilhermeplasma on 12/06/17.
 */
@Entity
@Table(name = "funcionario", schema = "locacao", catalog = "")
public class Funcionario {
    private int idfuncionario;
    private String cpf;
    private Date dataNascimento;
    private String matricula;
    private String nome;
    private String senha;
    private String usuario;

    @Id
    @Column(name = "idfuncionario")
    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
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
    @Column(name = "data_nascimento")
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Basic
    @Column(name = "matricula")
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funcionario that = (Funcionario) o;

        if (idfuncionario != that.idfuncionario) return false;
        if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
        if (dataNascimento != null ? !dataNascimento.equals(that.dataNascimento) : that.dataNascimento != null)
            return false;
        if (matricula != null ? !matricula.equals(that.matricula) : that.matricula != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (senha != null ? !senha.equals(that.senha) : that.senha != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfuncionario;
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        result = 31 * result + (matricula != null ? matricula.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        return result;
    }
}

package com.unitri.ppi.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by guilhermeplasma on 12/06/17.
 */
@Entity
@Table(name = "locacao", schema = "locacao", catalog = "")
public class Locacao {
    private int idLocacao;
    private Date dataLocacao;
    private int idCliente;
    private int idFuncionarioCad;
    private Integer idFuncionarioRec;
    private int idVeiculo;

    @Id
    @Column(name = "id_locacao")
    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    @Basic
    @Column(name = "data_locacao")
    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    @Basic
    @Column(name = "id_cliente")
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "id_funcionario_cad")
    public int getIdFuncionarioCad() {
        return idFuncionarioCad;
    }

    public void setIdFuncionarioCad(int idFuncionarioCad) {
        this.idFuncionarioCad = idFuncionarioCad;
    }

    @Basic
    @Column(name = "id_funcionario_rec")
    public Integer getIdFuncionarioRec() {
        return idFuncionarioRec;
    }

    public void setIdFuncionarioRec(Integer idFuncionarioRec) {
        this.idFuncionarioRec = idFuncionarioRec;
    }

    @Basic
    @Column(name = "id_veiculo")
    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locacao that = (Locacao) o;

        if (idLocacao != that.idLocacao) return false;
        if (idCliente != that.idCliente) return false;
        if (idFuncionarioCad != that.idFuncionarioCad) return false;
        if (idVeiculo != that.idVeiculo) return false;
        if (dataLocacao != null ? !dataLocacao.equals(that.dataLocacao) : that.dataLocacao != null) return false;
        if (idFuncionarioRec != null ? !idFuncionarioRec.equals(that.idFuncionarioRec) : that.idFuncionarioRec != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLocacao;
        result = 31 * result + (dataLocacao != null ? dataLocacao.hashCode() : 0);
        result = 31 * result + idCliente;
        result = 31 * result + idFuncionarioCad;
        result = 31 * result + (idFuncionarioRec != null ? idFuncionarioRec.hashCode() : 0);
        result = 31 * result + idVeiculo;
        return result;
    }
}

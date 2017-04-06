/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitri.ppi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "locacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l")
    , @NamedQuery(name = "Locacao.findByIdLocacao", query = "SELECT l FROM Locacao l WHERE l.idLocacao = :idLocacao")
    , @NamedQuery(name = "Locacao.findByDataLocacao", query = "SELECT l FROM Locacao l WHERE l.dataLocacao = :dataLocacao")})
public class Locacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_locacao")
    private Integer idLocacao;
    @Column(name = "data_locacao")
    @Temporal(TemporalType.DATE)
    private Date dataLocacao;
    @ManyToMany(mappedBy = "locacaoList")
    @JsonBackReference
    private List<Multa> multaList;
    @ManyToMany(mappedBy = "locacaoList")
    @JsonBackReference
    private List<Avaria> avariaList;
    @JoinColumn(name = "id_funcionario_rec", referencedColumnName = "idfuncionario")
    @ManyToOne
    @JsonBackReference
    private Funcionario idFuncionarioRec;
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id_veiculo")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Veiculo idVeiculo;
    @JoinColumn(name = "id_funcionario_cad", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Funcionario idFuncionarioCad;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Cliente idCliente;

    public Locacao() {
    }

    public Locacao(Integer idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Integer getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(Integer idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    @XmlTransient
    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    @XmlTransient
    public List<Avaria> getAvariaList() {
        return avariaList;
    }

    public void setAvariaList(List<Avaria> avariaList) {
        this.avariaList = avariaList;
    }

    public Funcionario getIdFuncionarioRec() {
        return idFuncionarioRec;
    }

    public void setIdFuncionarioRec(Funcionario idFuncionarioRec) {
        this.idFuncionarioRec = idFuncionarioRec;
    }

    public Veiculo getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Veiculo idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Funcionario getIdFuncionarioCad() {
        return idFuncionarioCad;
    }

    public void setIdFuncionarioCad(Funcionario idFuncionarioCad) {
        this.idFuncionarioCad = idFuncionarioCad;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocacao != null ? idLocacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locacao)) {
            return false;
        }
        Locacao other = (Locacao) object;
        if ((this.idLocacao == null && other.idLocacao != null) || (this.idLocacao != null && !this.idLocacao.equals(other.idLocacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unitri.ppi.domain.Locacao[ idLocacao=" + idLocacao + " ]";
    }
    
}

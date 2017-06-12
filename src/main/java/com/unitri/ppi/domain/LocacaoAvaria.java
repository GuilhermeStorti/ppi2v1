package com.unitri.ppi.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guilhermeplasma on 12/06/17.
 */
@Entity
@Table(name = "locacao_avaria", schema = "locacao", catalog = "")
public class LocacaoAvaria implements Serializable{
    private int idAvaria;
    private int idLocacao;

    @Id
    @Basic
    @Column(name = "id_avaria")
    public int getIdAvaria() {
        return idAvaria;
    }

    public void setIdAvaria(int idAvaria) {
        this.idAvaria = idAvaria;
    }

    @Id
    @Basic
    @Column(name = "id_locacao")
    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocacaoAvaria that = (LocacaoAvaria) o;

        if (idAvaria != that.idAvaria) return false;
        if (idLocacao != that.idLocacao) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAvaria;
        result = 31 * result + idLocacao;
        return result;
    }
}

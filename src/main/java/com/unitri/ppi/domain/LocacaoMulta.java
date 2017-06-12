package com.unitri.ppi.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guilhermeplasma on 12/06/17.
 */
@Entity
@Table(name = "locacao_multa", schema = "locacao", catalog = "")
public class LocacaoMulta implements Serializable{



    private int idLocacao;
    private int idMulta;

    @Id
    @Basic
    @Column(name = "id_locacao")
    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    @Id
    @Basic
    @Column(name = "id_multa")
    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocacaoMulta that = (LocacaoMulta) o;

        if (idLocacao != that.idLocacao) return false;
        if (idMulta != that.idMulta) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLocacao;
        result = 31 * result + idMulta;
        return result;
    }
}

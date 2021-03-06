package com.unitri.ppi.domain;

import javax.persistence.*;

/**
 * Created by guilhermeplasma on 12/06/17.
 */
@Entity
@Table(name = "avaria", schema = "locacao", catalog = "")
public class Avaria {
    private int idAvaria;
    private String descricao;

    @Id
    @Column(name = "id_avaria")
    public int getIdAvaria() {
        return idAvaria;
    }

    public void setIdAvaria(int idAvaria) {
        this.idAvaria = idAvaria;
    }

    @Basic
    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Avaria that = (Avaria) o;

        if (idAvaria != that.idAvaria) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAvaria;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}

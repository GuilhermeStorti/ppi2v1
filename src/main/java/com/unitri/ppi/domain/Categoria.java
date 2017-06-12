package com.unitri.ppi.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by guilhermeplasma on 12/06/17.
 */
@Entity
@Table(name = "categoria", schema = "locacao", catalog = "")
public class Categoria {
    private int idCategoria;
    private String descricao;
    private BigDecimal preco;

    @Id
    @Column(name = "id_categoria")
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Basic
    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Basic
    @Column(name = "preco")
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria that = (Categoria) o;

        if (idCategoria != that.idCategoria) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (preco != null ? !preco.equals(that.preco) : that.preco != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategoria;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        return result;
    }
}

package com.unitri.ppi.domain;

import javax.persistence.*;

/**
 * Created by guilhermeplasma on 12/06/17.
 */
@Entity
@Table(name = "multa", schema = "locacao", catalog = "")
public class Multa {
    private int idMulta;
    private String descricao;
    private double valor;
    private int idVeiculo;

    @Id
    @Column(name = "id_multa")
    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
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
    @Column(name = "valor")
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

        Multa that = (Multa) o;

        if (idMulta != that.idMulta) return false;
        if (Double.compare(that.valor, valor) != 0) return false;
        if (idVeiculo != that.idVeiculo) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idMulta;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        temp = Double.doubleToLongBits(valor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + idVeiculo;
        return result;
    }
}

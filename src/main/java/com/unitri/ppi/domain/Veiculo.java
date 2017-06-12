package com.unitri.ppi.domain;

import javax.persistence.*;

/**
 * Created by guilhermeplasma on 12/06/17.
 */
@Entity
@Table(name = "veiculo", schema = "locacao", catalog = "")
public class Veiculo {
    private int idVeiculo;
    private String marca;
    private String modelo;
    private String placa;
    private int idCategoria;

    @Id
    @Column(name = "id_veiculo")
    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Basic
    @Column(name = "marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Basic
    @Column(name = "modelo")
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Basic
    @Column(name = "placa")
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Basic
    @Column(name = "id_categoria")
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veiculo that = (Veiculo) o;

        if (idVeiculo != that.idVeiculo) return false;
        if (idCategoria != that.idCategoria) return false;
        if (marca != null ? !marca.equals(that.marca) : that.marca != null) return false;
        if (modelo != null ? !modelo.equals(that.modelo) : that.modelo != null) return false;
        if (placa != null ? !placa.equals(that.placa) : that.placa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVeiculo;
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (placa != null ? placa.hashCode() : 0);
        result = 31 * result + idCategoria;
        return result;
    }
}

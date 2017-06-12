package com.unitri.ppi.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.unitri.ppi.domain.Funcionario;
import com.unitri.ppi.domain.Locacao;
import com.unitri.ppi.domain.Veiculo;
import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class FuncionarioRepresentation extends ResourceSupport {

    @JsonInclude(Include.NON_NULL)
    private Integer idFuncionario;

    @JsonInclude(Include.NON_NULL)
    private String matricula;

    @JsonInclude(Include.NON_NULL)
    private String nome;

    @JsonInclude(Include.NON_NULL)
    private String usuario;

    @JsonInclude(Include.NON_NULL)
    private String senha;

    @JsonInclude(Include.NON_NULL)
    private String cpf;

    @JsonInclude(Include.NON_NULL)
    private Date dataNascimento;

    @JsonIgnore
    private List<Locacao> locacaoList;

    public FuncionarioRepresentation() {
    }

    public FuncionarioRepresentation(Integer idFuncionario, String matricula, String nome, String usuario, String senha, String cpf, Date dataNascimento, List<Locacao> locacaoList) {
        this.idFuncionario = idFuncionario;
        this.matricula = matricula;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.locacaoList = locacaoList;
    }

    public FuncionarioRepresentation(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdfuncionario();
        this.matricula = funcionario.getMatricula();
        this.nome = funcionario.getNome();
        this.usuario = funcionario.getUsuario();
        this.senha = funcionario.getSenha();
        this.cpf = funcionario.getCpf();
        this.dataNascimento = funcionario.getDataNascimento();
        this.locacaoList = funcionario.getLocacaoList();
    }

    public static Funcionario build (FuncionarioRepresentation representation){
        Funcionario funcionario = new Funcionario();

        funcionario.setIdfuncionario(representation.getIdFuncionario());
        funcionario.setMatricula(representation.getMatricula());
        funcionario.setNome(representation.getNome());
        funcionario.setUsuario(representation.getUsuario());
        funcionario.setSenha(representation.getSenha());
        funcionario.setCpf(representation.getCpf());
        funcionario.setDataNascimento(representation.getDataNascimento());
        funcionario.setLocacaoList(funcionario.getLocacaoList());

        return funcionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Locacao> getLocacaoList() {
        return locacaoList;
    }

    public void setLocacaoList(List<Locacao> locacaoList) {
        this.locacaoList = locacaoList;
    }
}

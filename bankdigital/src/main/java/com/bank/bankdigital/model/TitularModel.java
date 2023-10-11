package com.bank.bankdigital.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class TitularModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTitular;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private Date dataNasc;

    @Column(nullable = false, unique = true)
    private String cpfCnpj;


    @OneToOne(mappedBy = "idTitular")
    private EnderecoModel enderecoPrincipal;
    

    @OneToMany(mappedBy = "idTitular")
    private List<ContaBancariaModel> contas;
    
    
    public TitularModel(Long id, String nome, String email, String telefone, Date dataNasc, String cpfCnpj, EnderecoModel enderecoPrincipal, ContaBancariaModel conta) {
        this.idTitular = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.cpfCnpj = cpfCnpj;
        this.enderecoPrincipal = enderecoPrincipal;
        this.contas = new ArrayList<ContaBancariaModel>();
        this.contas.add(conta);
    }
    

    public Long getIdTitular() {
        return idTitular;
    }
    public void setIdTitular(Long idTitular) {
        this.idTitular = idTitular;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Date getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    public EnderecoModel getEnderecoPrincipal() {
        return enderecoPrincipal;
    }
    public void setEnderecoPrincipal(EnderecoModel enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }
    public List<ContaBancariaModel> getContas() {
        return contas;
    }
    public void setContas(List<ContaBancariaModel> contas) {
        this.contas = contas;
    }

}

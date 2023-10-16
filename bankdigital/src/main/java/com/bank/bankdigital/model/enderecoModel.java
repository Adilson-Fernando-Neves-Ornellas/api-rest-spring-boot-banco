package com.bank.bankdigital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.bank.bankdigital.dto.EnderecoDtos.EnderecoRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class EnderecoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
     
    @Column(nullable = false)
    private String cep;
    private int  numeroCasa;
    private String complemento;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    @OneToOne()
    @JoinColumn(name = "idTitular",nullable = false )
    @JsonBackReference
    private TitularModel idTitular;

    
    //constructors 
    public EnderecoModel() {
    }
    

    // public EnderecoModel(EnderecoRequestDto enderecoRequest) {
    //     this.idEndereco = 0l;
    //     this.cep=enderecoRequest.getCep();
    //     this.numeroCasa=enderecoRequest.getNumeroCasa();
    //     this.complemento=enderecoRequest.getComplemento();
    //     this.logradouro=enderecoRequest.getLogradouro();
    //     this.bairro=enderecoRequest.getBairro();
    //     this.cidade=enderecoRequest.getCidade();
    //     this.estado=enderecoRequest.getEstado();
    //     this.pais=enderecoRequest.getPais();
    // }


    // get e set
    public TitularModel getIdTitular() {
        return idTitular;
    }
    public void setIdTitular(TitularModel idTitular) {
        this.idTitular = idTitular;
    }
    public Long getIdEndereco() {
        return idEndereco;
    }
    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public int getNumeroCasa() {
        return numeroCasa;
    }
    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

}

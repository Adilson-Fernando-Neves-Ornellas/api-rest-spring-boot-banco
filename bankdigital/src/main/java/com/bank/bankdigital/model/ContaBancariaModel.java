package com.bank.bankdigital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bank.bankdigital.dto.ContaBancariaDtos.ContaBancariaRequestDto;
import com.bank.bankdigital.dto.EnderecoDtos.EnderecoRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ContaBancariaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContaBancaria;
    
    // @Column(nullable = false, length = 4)
    private String agenciaBanco;

    // @Column(nullable = false, unique = true, length = 6)
    private String numeroContaCorrente;

    // @Column(nullable = false)
    private double saldoContaCorrente;
    
    // @Column(nullable = false)
    private Date dataCadastro;

    @ManyToOne()
    @JoinColumn(name = "idTitular")
    @JsonBackReference
    private TitularModel idTitular;

        //constructors 
    public ContaBancariaModel() {
        this.dataCadastro = new Date();
    }
    
    // public ContaBancariaModel(ContaBancariaRequestDto request) {
    //     this.idContaBancaria = 0l;
    //     this.agenciaBanco=request.getAgenciaBanco();
    //     this.numeroContaCorrente=request.getNumeroContaCorrente();
    //     this.saldoContaCorrente=request.getSaldoContaCorrente();
    //     this.dataCadastro = new Date();
    // }

    public ContaBancariaModel(long id, String agenciaBanco, String numeroContaCorrente, double saldoContaCorrente) {
        this.idContaBancaria = id;
        this.agenciaBanco = agenciaBanco;
        this.numeroContaCorrente = numeroContaCorrente;
        this.saldoContaCorrente = saldoContaCorrente;
        this.dataCadastro = new Date();
    }

    // get and set
    public TitularModel getIdTitular() {
        return idTitular;
    }
    public void setIdTitular(TitularModel idTitular) {
        this.idTitular = idTitular;
    }
    public long getIdContaBancaria() {
        return idContaBancaria;
    }
    public void setIdContaBancaria(long idContaBancaria) {
        this.idContaBancaria = idContaBancaria;
    }
    public String getAgenciaBanco() {
        return agenciaBanco;
    }
    public String getNumeroContaCorrente() {
        return numeroContaCorrente;
    }
    public double getSaldoContaCorrente() {
        return saldoContaCorrente;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    
}

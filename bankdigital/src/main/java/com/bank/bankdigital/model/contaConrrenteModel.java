package com.bank.bankdigital.model;

import java.util.Date;

public class contaConrrenteModel {
    
    private long id;
    private String agenciaBanco; 
    private String numeroContaCorrente;
    private double saldoContaCorrente;
    private Date dataCadastro;

    

    public contaConrrenteModel(long id, String agenciaBanco, String numeroContaCorrente, double saldoContaCorrente) {
        this.id = id;
        this.agenciaBanco = agenciaBanco;
        this.numeroContaCorrente = numeroContaCorrente;
        this.saldoContaCorrente = saldoContaCorrente;
        this.dataCadastro = new Date();
    }
    

    public contaConrrenteModel() {
        this.dataCadastro = new Date();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

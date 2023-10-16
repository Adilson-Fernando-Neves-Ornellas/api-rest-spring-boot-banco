package com.bank.bankdigital.dto.ContaBancariaDtos;


public abstract class ContaBancariaBaseDto {
    
    protected String agenciaBanco;

    protected String numeroContaCorrente;

    public String getAgenciaBanco() {
        return agenciaBanco;
    }

    public void setAgenciaBanco(String agenciaBanco) {
        this.agenciaBanco = agenciaBanco;
    }

    public String getNumeroContaCorrente() {
        return numeroContaCorrente;
    }

    public void setNumeroContaCorrente(String numeroContaCorrente) {
        this.numeroContaCorrente = numeroContaCorrente;
    }


}

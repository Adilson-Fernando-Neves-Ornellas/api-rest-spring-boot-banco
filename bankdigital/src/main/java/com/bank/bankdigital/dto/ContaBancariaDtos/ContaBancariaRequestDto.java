package com.bank.bankdigital.dto.ContaBancariaDtos;

// import com.bank.bankdigital.dto.TitularDtos.TitularRequestDto;

public class ContaBancariaRequestDto extends ContaBancariaBaseDto {
    
    private double saldoContaCorrente;
    // private TitularRequestDto idTitular;

    public double getSaldoContaCorrente() {
        return saldoContaCorrente;
    }

    public void setSaldoContaCorrente(double saldoContaCorrente) {
        this.saldoContaCorrente = saldoContaCorrente;
    }

    
}

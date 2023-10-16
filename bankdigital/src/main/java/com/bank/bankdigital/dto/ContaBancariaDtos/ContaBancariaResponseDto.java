package com.bank.bankdigital.dto.ContaBancariaDtos;

import java.util.Date;

import com.bank.bankdigital.model.ContaBancariaModel;

public class ContaBancariaResponseDto extends ContaBancariaBaseDto{

    private long idContaBancaria;
    private Date dataCadastro;

    // constructors
    
    // public ContaBancariaResponseDto() {
    // }
    
    // public ContaBancariaResponseDto(ContaBancariaModel model) {
    //     this.idContaBancaria= model.getIdContaBancaria();
    //     this.dataCadastro = model.getDataCadastro();
    //     this.agenciaBanco = model.getAgenciaBanco();
    //     this.numeroContaCorrente = model.getNumeroContaCorrente();
    // }

    // get and set
    public long getIdContaBancaria() {
        return idContaBancaria;
    }
    public void setIdContaBancaria(long idContaBancaria) {
        this.idContaBancaria = idContaBancaria;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    
}

package com.bank.bankdigital.dto.TitularDtos;

import java.util.Date;

public abstract class TitularBaseDto {

    protected Long idTitular;

    protected String nome;

    protected String email;

    protected String telefone;

    protected Date dataNasc;

    protected String cpfCnpj;


    // getters and setters

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
    
}

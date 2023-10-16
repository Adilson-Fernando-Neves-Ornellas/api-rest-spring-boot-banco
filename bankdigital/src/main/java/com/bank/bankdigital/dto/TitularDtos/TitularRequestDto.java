package com.bank.bankdigital.dto.TitularDtos;

import java.util.List;

import com.bank.bankdigital.dto.ContaBancariaDtos.ContaBancariaRequestDto;
import com.bank.bankdigital.dto.EnderecoDtos.EnderecoRequestDto;

public class TitularRequestDto extends TitularBaseDto{
    
    protected EnderecoRequestDto enderecoPrincipal;
    
    protected List<ContaBancariaRequestDto> contas;

    public EnderecoRequestDto getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(EnderecoRequestDto enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public List<ContaBancariaRequestDto> getContas() {
        return contas;
    }

    public void setContas(List<ContaBancariaRequestDto> contas) {
        this.contas = contas;
    }
    
}

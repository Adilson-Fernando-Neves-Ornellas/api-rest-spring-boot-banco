package com.bank.bankdigital.dto.TitularDtos;

import java.util.ArrayList;
import java.util.List;

import com.bank.bankdigital.dto.ContaBancariaDtos.ContaBancariaResponseDto;
import com.bank.bankdigital.dto.EnderecoDtos.EnderecoResponseDto;
import com.bank.bankdigital.model.ContaBancariaModel;
import com.bank.bankdigital.model.TitularModel;


public class TitularResponseDto extends TitularBaseDto {
    
    private Long idTitular;
    private EnderecoResponseDto enderecoPrincipal;
    private List<ContaBancariaResponseDto> contas;

        // constructor
        
    // public TitularResponseDto() {
    // }
    
    // public TitularResponseDto(TitularModel model) {
    //     this.idTitular= model.getIdTitular();
    //     this.nome = model.getNome();
    //     this.email = model.getEmail();
    //     this.telefone= model.getTelefone();
    //     this.dataNasc= model.getDataNasc();
    //     this.cpfCnpj = model.getCpfCnpj();
    //     this.enderecoPrincipal = new EnderecoResponseDto(model.getEnderecoPrincipal());
    //     // Converte a lista de ContaBancariaModel para ContaBancariaResponseDto
    //     this.contas = new ArrayList<>();
    //     for (ContaBancariaModel conta : model.getContas()) {
    //         this.contas.add(new ContaBancariaResponseDto(conta));
    //     }
    // }

    // get and set
    public Long getIdTitular() {
        return idTitular;
    }
    public void setIdTitular(Long idTitular) {
        this.idTitular = idTitular;
    }
    public EnderecoResponseDto getEnderecoPrincipal() {
        return enderecoPrincipal;
    }
    public void setEnderecoPrincipal(EnderecoResponseDto enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }
    public List<ContaBancariaResponseDto> getContas() {
        return contas;
    }
    public void setContas(List<ContaBancariaResponseDto> contas) {
        this.contas = contas;
    }
}

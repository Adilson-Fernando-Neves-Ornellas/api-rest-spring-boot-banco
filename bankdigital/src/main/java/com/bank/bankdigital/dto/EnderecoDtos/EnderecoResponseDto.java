package com.bank.bankdigital.dto.EnderecoDtos;

import com.bank.bankdigital.model.EnderecoModel;

public class EnderecoResponseDto extends EnderecoBaseDto {

    private Long idEndereco;


    // constructor
    
    // public EnderecoResponseDto() {
    // }
    
    // public EnderecoResponseDto(EnderecoModel enderecoModel) {
    //     this.idEndereco= enderecoModel.getIdEndereco();
    //     this.cep = enderecoModel.getCep();
    //     this.logradouro = enderecoModel.getLogradouro();
    //     this.complemento = enderecoModel.getComplemento();
    //     this.bairro = enderecoModel.getBairro();
    //     this.cidade = enderecoModel.getCidade();
    //     this.estado = enderecoModel.getEstado();
    //     this.pais = enderecoModel.getPais();
    //     this.numeroCasa = enderecoModel.getNumeroCasa();
    // }

    // get and set
    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }
    
    
}

package com.bank.bankdigital.dto.EnderecoDtos;

import com.bank.bankdigital.dto.TitularDtos.TitularRequestDto;

public class EnderecoRequestDto extends EnderecoBaseDto {

        private TitularRequestDto idTitular;
        

        public TitularRequestDto getIdTitular() {
                return idTitular;
        }

        public void setIdTitular(TitularRequestDto idTitular) {
                this.idTitular = idTitular;
        }


}

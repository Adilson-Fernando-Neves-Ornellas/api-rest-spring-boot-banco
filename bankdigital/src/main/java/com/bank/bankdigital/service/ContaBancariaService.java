package com.bank.bankdigital.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankdigital.dto.ContaBancariaDtos.ContaBancariaRequestDto;
import com.bank.bankdigital.dto.ContaBancariaDtos.ContaBancariaResponseDto;
import com.bank.bankdigital.dto.EnderecoDtos.EnderecoResponseDto;
import com.bank.bankdigital.model.ContaBancariaModel;
import com.bank.bankdigital.model.EnderecoModel;
import com.bank.bankdigital.repository.ContaBancariaRepository;


@Service
public class ContaBancariaService {
        
    @Autowired
    private ContaBancariaRepository contaBancariaRepositoryAction;

    @Autowired
    private ModelMapper modelMapperAction;

    public List<ContaBancariaResponseDto> obterTodos(){
        List<ContaBancariaModel> listModel = contaBancariaRepositoryAction.findAll();
        
        List<ContaBancariaResponseDto> listResponse = new ArrayList<>();

        for(var i = 0; i < listModel.size(); i++){
            listResponse.add(modelMapperAction.map(listModel.get(i), ContaBancariaResponseDto.class));
        }

        return listResponse;
    }

    public ContaBancariaResponseDto obterId(Long id){
        Optional<ContaBancariaModel> optinal = contaBancariaRepositoryAction.findById(id);

        if(optinal.isEmpty()){
            throw new RuntimeException("Nenhum registro encontrado para o ID: " + id);
        }
        return modelMapperAction.map(optinal.get(), ContaBancariaResponseDto.class);
    }

    public ContaBancariaResponseDto adicionar(ContaBancariaRequestDto contaBancariaRequest){
        
        ContaBancariaModel contaBancaria = modelMapperAction.map(contaBancariaRequest, ContaBancariaModel.class);
        contaBancaria.setIdContaBancaria(0);
        
        contaBancaria = contaBancariaRepositoryAction.save(contaBancaria);
        
        return modelMapperAction.map(contaBancaria, ContaBancariaResponseDto.class); 
    }

    public ContaBancariaResponseDto atualizar (ContaBancariaRequestDto contaBancariaRequest, Long id){
        obterId(id);
        ContaBancariaModel contaBancaria = modelMapperAction.map(contaBancariaRequest, ContaBancariaModel.class);

        contaBancaria.setIdContaBancaria(id);
        contaBancaria = contaBancariaRepositoryAction.save(contaBancaria);

        return modelMapperAction.map(contaBancaria, ContaBancariaResponseDto.class);
    }

    public void deletar (Long id){
        obterId(id);
        contaBancariaRepositoryAction.deleteById(id);
    }

}

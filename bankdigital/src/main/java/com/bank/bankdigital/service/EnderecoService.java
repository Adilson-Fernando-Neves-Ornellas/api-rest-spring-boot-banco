package com.bank.bankdigital.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankdigital.dto.EnderecoDtos.EnderecoRequestDto;
import com.bank.bankdigital.dto.EnderecoDtos.EnderecoResponseDto;
import com.bank.bankdigital.model.EnderecoModel;
import com.bank.bankdigital.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepositoryAction;

    @Autowired
    private ModelMapper modelMapperAction;

    public List<EnderecoResponseDto> obterTodos(){
        List<EnderecoModel> listModel = enderecoRepositoryAction.findAll();
        
        List<EnderecoResponseDto> listResponse = new ArrayList<>();

        for(var i = 0; i < listModel.size(); i++){
            listResponse.add(modelMapperAction.map(listModel.get(i), EnderecoResponseDto.class));
        }

        return listResponse ;
    }

    public EnderecoResponseDto obterId(Long id){
        Optional<EnderecoModel> optinal = enderecoRepositoryAction.findById(id);

        if(optinal.isEmpty()){
            throw new RuntimeException("Nenhum registro encontrado para o ID: " + id);
        }
        return modelMapperAction.map(optinal.get(), EnderecoResponseDto.class);
    }

    public EnderecoResponseDto adicionar(EnderecoRequestDto enderecoRequest){

        EnderecoModel enderecoModel = modelMapperAction.map(enderecoRequest, EnderecoModel.class);
        enderecoModel = enderecoRepositoryAction.save(enderecoModel);
        return  modelMapperAction.map(enderecoModel, EnderecoResponseDto.class);
    }

    public EnderecoResponseDto atualizar (EnderecoRequestDto endereco, Long id){
        obterId(id);

        EnderecoModel enderecoModel = enderecoRepositoryAction.save(modelMapperAction.map(endereco, EnderecoModel.class));

        return modelMapperAction.map(enderecoModel, EnderecoResponseDto.class);
    }

    public void deletar (Long id){
        obterId(id);
        enderecoRepositoryAction.deleteById(id);
    }

}

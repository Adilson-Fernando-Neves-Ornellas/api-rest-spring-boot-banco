package com.bank.bankdigital.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankdigital.dto.ContaBancariaDtos.ContaBancariaRequestDto;
import com.bank.bankdigital.dto.ContaBancariaDtos.ContaBancariaResponseDto;
import com.bank.bankdigital.dto.EnderecoDtos.EnderecoRequestDto;
import com.bank.bankdigital.dto.EnderecoDtos.EnderecoResponseDto;
import com.bank.bankdigital.dto.TitularDtos.TitularRequestDto;
import com.bank.bankdigital.dto.TitularDtos.TitularResponseDto;
import com.bank.bankdigital.model.ContaBancariaModel;
import com.bank.bankdigital.model.EnderecoModel;
import com.bank.bankdigital.model.TitularModel;

import org.modelmapper.ModelMapper;
import com.bank.bankdigital.repository.TitularRepository;


@Service
public class TitularService {

    @Autowired
    private TitularRepository titularRepositoryAction;

    @Autowired
    private EnderecoService enderecoServiceAction;

    @Autowired
    private ContaBancariaService contaBancariaServiceAction;

    @Autowired
    private ModelMapper modelMapperAction;

    public List<TitularResponseDto> obterTodos(){
        List<TitularModel> listModel = titularRepositoryAction.findAll();
        
        List<TitularResponseDto> listResponse = new ArrayList<>();

        for(var i = 0; i < listModel.size(); i++){
            listResponse.add(modelMapperAction.map(listModel.get(i), TitularResponseDto.class));
        }

        return listResponse;
    }

    public TitularResponseDto obterId(Long id){
        Optional<TitularModel> optinal = titularRepositoryAction.findById(id);

        if(optinal.isEmpty()){
            throw new RuntimeException("Nenhum registro encontrado para o ID: " + id);
        }
        return modelMapperAction.map(optinal.get(), TitularResponseDto.class);
    }

    @Transactional
    public TitularResponseDto adicionar(TitularRequestDto titular){ 
        TitularModel titularModel = adicionarTitular(titular);
        EnderecoRequestDto enderecoRequest = titular.getEnderecoPrincipal();
        
        titular.setIdTitular(titularModel.getIdTitular());

        enderecoRequest.setIdTitular(titular);
        EnderecoModel enderecoModel = adicionarEndereco(enderecoRequest);

        titularModel.setEnderecoPrincipal(enderecoModel);

        List<ContaBancariaModel> contas = adicionarContas(titular.getContas(), titularModel);
        titularModel.setContas(contas);

        return modelMapperAction.map(titularModel, TitularResponseDto.class);
    }

    public TitularResponseDto atualizar (TitularRequestDto titular, Long id){
        obterId(id);

        titular.setIdTitular(id);
        TitularModel titularModel = titularRepositoryAction.save(modelMapperAction.map(titular, TitularModel.class));

        return modelMapperAction.map(titularModel, TitularResponseDto.class);
    }

    public void deletar (Long id){
        obterId(id);
        titularRepositoryAction.deleteById(id);
    }

    // -----------------------------------------------------------------------------------

    private TitularModel adicionarTitular(TitularRequestDto titularRequest){

        TitularModel titularModel = modelMapperAction.map(titularRequest, TitularModel.class);
        titularModel.setIdTitular(0l);
        titularModel = titularRepositoryAction.save(titularModel);

        return titularModel;
    }

    private EnderecoModel adicionarEndereco(EnderecoRequestDto enderecoRequest){
        
        EnderecoResponseDto enderecoResponse = enderecoServiceAction.adicionar(enderecoRequest);

        return modelMapperAction.map(enderecoResponse, EnderecoModel.class);
    }

    private List<ContaBancariaModel> adicionarContas(List<ContaBancariaRequestDto> contasRequest, TitularModel titularModel){
        
        List<ContaBancariaModel> adicionadas = new ArrayList<>();

        for(ContaBancariaRequestDto contaBancariaRequest : contasRequest){

            ContaBancariaResponseDto contaBancariaResponse = contaBancariaServiceAction.adicionar(contaBancariaRequest);
            
            ContaBancariaModel contaBancaria = modelMapperAction.map(contaBancariaResponse, ContaBancariaModel.class);

            contaBancaria.setIdTitular(titularModel);
            
            adicionadas.add(contaBancaria);

        }

        return adicionadas;
    }

}

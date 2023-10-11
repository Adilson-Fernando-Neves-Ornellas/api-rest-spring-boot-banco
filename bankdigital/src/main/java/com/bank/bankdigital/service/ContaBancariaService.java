package com.bank.bankdigital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankdigital.model.ContaBancariaModel;
import com.bank.bankdigital.repository.ContaBancariaRepository;


@Service
public class ContaBancariaService {
        
    @Autowired
    private ContaBancariaRepository contaBancariaRepositoryAction;

    public List<ContaBancariaModel> obterTodos(){
        return contaBancariaRepositoryAction.findAll();
    }

    public ContaBancariaModel obterId(Long id){
        Optional<ContaBancariaModel> optinal = contaBancariaRepositoryAction.findById(id);
        if(optinal.isEmpty()){
            throw new RuntimeException("Id não encontrado: " + id);
        }
     return optinal.get();
    }

    public ContaBancariaModel adicionar(ContaBancariaModel contaBancaria){
        contaBancaria.setIdContaBancaria( (long) 0);
     return contaBancariaRepositoryAction.save(contaBancaria);
    }

    public ContaBancariaModel atualizar (ContaBancariaModel contaBancaria, Long id){
        obterId(id);
        contaBancaria.setIdContaBancaria(id);
     return contaBancariaRepositoryAction.save(contaBancaria);
    }

    public void deletar (Long id){
        obterId(id);
        contaBancariaRepositoryAction.deleteById(id);
    }

}

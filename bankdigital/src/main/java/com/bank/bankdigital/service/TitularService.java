package com.bank.bankdigital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.bankdigital.model.TitularModel;


import com.bank.bankdigital.repository.TitularRepository;

@Service
public class TitularService {

    @Autowired
    private TitularRepository titularRepositoryAction;

    public List<TitularModel> obterTodos(){
        return titularRepositoryAction.findAll();
    }

    public TitularModel obterId(Long id){
        Optional<TitularModel> optinal = titularRepositoryAction.findById(id);
        if(optinal.isEmpty()){
            throw new RuntimeException("Id não encontrado: " + id);
        }
     return optinal.get();
    }

    public TitularModel adicionar(TitularModel titular){
        titular.setIdTitular( (long) 0);
     return titularRepositoryAction.save(titular);
    }

    public TitularModel atualizar (TitularModel titular, Long id){
        obterId(id);
        titular.setIdTitular(id);
     return titularRepositoryAction.save(titular);
    }

    public void deletar (Long id){
        obterId(id);
        titularRepositoryAction.deleteById(id);
    }

}

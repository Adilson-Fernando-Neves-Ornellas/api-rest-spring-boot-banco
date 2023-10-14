package com.bank.bankdigital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankdigital.model.EnderecoModel;
import com.bank.bankdigital.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository EnderecoRepositoryAction;

    public List<EnderecoModel> obterTodos(){
        return EnderecoRepositoryAction.findAll();
    }

    public EnderecoModel obterId(Long id){
        Optional<EnderecoModel> optinal = EnderecoRepositoryAction.findById(id);
        if(optinal.isEmpty()){
            throw new RuntimeException("Id não encontrado: " + id);
        }
     return optinal.get();
    }

    public EnderecoModel adicionar(EnderecoModel endereco){
        // endereco.setIdEndereco( (long) 0);
     return EnderecoRepositoryAction.save(endereco);
    }

    public EnderecoModel atualizar (EnderecoModel endereco, Long id){
        obterId(id);
        endereco.setIdEndereco(id);
     return EnderecoRepositoryAction.save(endereco);
    }

    public void deletar (Long id){
        obterId(id);
        EnderecoRepositoryAction.deleteById(id);
    }

}

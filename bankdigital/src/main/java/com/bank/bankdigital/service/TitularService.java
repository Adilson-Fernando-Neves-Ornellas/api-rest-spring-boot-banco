package com.bank.bankdigital.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankdigital.model.ContaBancariaModel;
import com.bank.bankdigital.model.EnderecoModel;
import com.bank.bankdigital.model.TitularModel;


import com.bank.bankdigital.repository.TitularRepository;

@Service
public class TitularService {

    @Autowired
    private TitularRepository titularRepositoryAction;

    @Autowired
    private EnderecoService enderecoServiceAction;

    @Autowired
    private ContaBancariaService contaBancariaServiceAction;

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

    @Transactional
    public TitularModel adicionar(TitularModel titular){
        // titular.setIdTitular( (long) 0);
      titularRepositoryAction.save(titular);

      EnderecoModel endereco = titular.getEnderecoPrincipal();

      if(endereco.getIdEndereco()==null){
        endereco.setIdTitular(titular);
        enderecoServiceAction.adicionar(endereco);
        titular.setEnderecoPrincipal(endereco);
      }

      List<ContaBancariaModel> contas = titular.getContas();
      for(int i=0 ;i <contas .size ();i++){
        if(contas.get(i).getIdContaBancaria()==0){
            contas.get(i).setIdTitular(titular);
            contaBancariaServiceAction.adicionar(contas.get(i));
        }
      }
      return   titular ;

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

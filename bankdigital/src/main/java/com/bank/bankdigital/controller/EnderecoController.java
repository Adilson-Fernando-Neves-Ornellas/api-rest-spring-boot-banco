package com.bank.bankdigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bankdigital.model.EnderecoModel;
import com.bank.bankdigital.service.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/Enderecos")
@Api(value = "ENDERECO")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoServiceAction;

    @GetMapping
    @ApiOperation(value = "RETORNA TODOS ")
    public ResponseEntity<List<EnderecoModel>> obterTodos(){
        return ResponseEntity.ok(enderecoServiceAction.obterTodos());
    }

    @GetMapping("{/id}")
    @ApiOperation(value = "RETORNA UM PELO ID")
    public ResponseEntity<EnderecoModel> obterId(@PathVariable Long id){
        return ResponseEntity.ok(enderecoServiceAction.obterId(id));
    }

    @PostMapping()
    @ApiOperation(value = "ADICIONA")
    public ResponseEntity<EnderecoModel> adicionar(@RequestBody EnderecoModel endereco){
        return ResponseEntity.status(201).body(enderecoServiceAction.adicionar(endereco));
    }

    @PostMapping("{/id}")
    @ApiOperation(value = "ATUALIZA PELO ID")
    public ResponseEntity<EnderecoModel> atualizar(@RequestBody EnderecoModel endereco, @PathVariable Long id){
        return ResponseEntity.status(201).body(enderecoServiceAction.atualizar(endereco, id));
    }

    @DeleteMapping("{/id}")
    @ApiOperation(value = "DELETA PELO ID")
    public ResponseEntity<?> delete(@PathVariable Long id){
        enderecoServiceAction.deletar(id);
        return ResponseEntity.status(204).build();
    }
    
}
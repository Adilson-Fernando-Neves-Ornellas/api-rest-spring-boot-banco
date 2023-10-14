package com.bank.bankdigital.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bankdigital.model.TitularModel;
import com.bank.bankdigital.service.TitularService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/titulares")
@Api(value = "TITULAR")
public class TitularController {
    
    @Autowired
    private TitularService titularServiceAction;

    @GetMapping
    @ApiOperation(value = "RETORNA TODOS ")
    public ResponseEntity<List<TitularModel>> obterTodos(){
        return ResponseEntity.ok(titularServiceAction.obterTodos());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "RETORNA UM PELO ID")
    public ResponseEntity<TitularModel> obterId(@PathVariable Long id){
        return ResponseEntity.ok(titularServiceAction.obterId(id));
    }

    @PostMapping()
    @ApiOperation(value = "ADICIONA")
    public ResponseEntity<TitularModel> adicionar(@RequestBody TitularModel titular){
        return ResponseEntity.status(201).body(titularServiceAction.adicionar(titular));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "ATUALIZA PELO ID")
    public ResponseEntity<TitularModel> atualizar(@RequestBody TitularModel titular, @PathVariable Long id){
        return ResponseEntity.status(201).body(titularServiceAction.atualizar(titular, id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "DELETA PELO ID")
    public ResponseEntity<?> delete(@PathVariable Long id){
        titularServiceAction.deletar(id);
        return ResponseEntity.status(204).build();
    }

}

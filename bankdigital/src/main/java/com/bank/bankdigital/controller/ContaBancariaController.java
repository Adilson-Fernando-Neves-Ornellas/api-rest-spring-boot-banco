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

import com.bank.bankdigital.dto.ContaBancariaDtos.ContaBancariaRequestDto;
import com.bank.bankdigital.dto.ContaBancariaDtos.ContaBancariaResponseDto;
import com.bank.bankdigital.service.ContaBancariaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/api/ContaBancaria")
@Api(value = "CONTA BANCARIA")
public class ContaBancariaController {
    
    @Autowired
    private ContaBancariaService contaBancariaServiceAction;

    @GetMapping
    @ApiOperation(value = "RETORNA TODOS ")
    public ResponseEntity<List<ContaBancariaResponseDto>> obterTodos(){
        return ResponseEntity.ok(contaBancariaServiceAction.obterTodos());
    }

    @GetMapping("{/id}")
    @ApiOperation(value = "RETORNA UM PELO ID")
    public ResponseEntity<ContaBancariaResponseDto> obterId(@PathVariable Long id){
        return ResponseEntity.ok(contaBancariaServiceAction.obterId(id));
    }

    @PostMapping()
    @ApiOperation(value = "ADICIONA")
    public ResponseEntity<ContaBancariaResponseDto> adicionar(@RequestBody ContaBancariaRequestDto contaBancaria){
        return ResponseEntity.status(201).body(contaBancariaServiceAction.adicionar(contaBancaria));
    }

    @PostMapping("{/id}")
    @ApiOperation(value = "ATUALIZA PELO ID")
    public ResponseEntity<ContaBancariaResponseDto> atualizar(@RequestBody ContaBancariaRequestDto contaBancaria, @PathVariable Long id){
        return ResponseEntity.status(201).body(contaBancariaServiceAction.atualizar(contaBancaria, id));
    }

    @DeleteMapping("{/id}")
    @ApiOperation(value = "DELETA PELO ID")
    public ResponseEntity<?> delete(@PathVariable Long id){
        contaBancariaServiceAction.deletar(id);
        return ResponseEntity.status(204).build();
    }
    
}

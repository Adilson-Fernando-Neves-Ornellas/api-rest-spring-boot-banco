package com.bank.bankdigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.bankdigital.model.EnderecoModel;

public interface EnderecoRepository extends JpaRepository<EnderecoModel,Long> {
    
}

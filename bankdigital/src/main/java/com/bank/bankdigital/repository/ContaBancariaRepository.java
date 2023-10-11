package com.bank.bankdigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.bankdigital.model.ContaBancariaModel;

public interface ContaBancariaRepository extends JpaRepository<ContaBancariaModel,Long> {
    
}

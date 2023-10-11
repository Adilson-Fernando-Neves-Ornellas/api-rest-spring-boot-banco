package com.bank.bankdigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.bankdigital.model.TitularModel;

public interface TitularRepository extends JpaRepository<TitularModel, Long>{
        
}

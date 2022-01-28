package com.springboot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.application.model.Caixa;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {

}

package com.springboot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.application.model.Conta_Pagar;

@Repository
public interface Conta_PagarRepository extends JpaRepository<Conta_Pagar, Long> {

}

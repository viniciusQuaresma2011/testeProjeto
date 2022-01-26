package com.springboot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.application.model.Conta_Receber;

@Repository
public interface Conta_ReceberRepository extends JpaRepository<Conta_Receber, Long> {

}

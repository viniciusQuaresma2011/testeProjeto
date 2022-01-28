package com.springboot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.application.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}

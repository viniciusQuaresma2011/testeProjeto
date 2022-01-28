package com.springboot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.application.model.Financeiro;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {

}

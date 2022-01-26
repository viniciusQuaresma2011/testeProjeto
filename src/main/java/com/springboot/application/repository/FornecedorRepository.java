package com.springboot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.application.model.Fornecedor;


@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}

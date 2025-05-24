package com.cefet.prova_20223006773.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.prova_20223006773.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
}

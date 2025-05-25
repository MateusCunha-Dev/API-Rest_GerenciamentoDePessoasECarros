package com.cefet.prova_20223006773.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.prova_20223006773.entities.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{
    List<Carro> findByPessoaId(Long pessoaId);
}

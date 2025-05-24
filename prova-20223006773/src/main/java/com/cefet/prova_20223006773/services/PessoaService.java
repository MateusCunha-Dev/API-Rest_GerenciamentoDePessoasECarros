package com.cefet.prova_20223006773.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.prova_20223006773.dto.PessoaDTO;
import com.cefet.prova_20223006773.entities.Pessoa;
import com.cefet.prova_20223006773.repositories.PessoaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    //buscar pessoa
    public List<PessoaDTO> findAll(){
        List<Pessoa> listaPessoa = pessoaRepository.findAll();
        return listaPessoa.stream().map(PessoaDTO::new).toList();
    }

    // Buscar por ID
    public PessoaDTO findById(Long id) {
    Pessoa pessoa = pessoaRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Tipo não encontrado com ID: " + id));
    return new PessoaDTO(pessoa);
    }

    


}

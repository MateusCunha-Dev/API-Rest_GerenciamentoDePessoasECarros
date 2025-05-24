package com.cefet.prova_20223006773.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.prova_20223006773.dto.CarroDTO;
import com.cefet.prova_20223006773.entities.Carro;
import com.cefet.prova_20223006773.repositories.CarroRepository;
import com.cefet.prova_20223006773.repositories.PessoaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private PessoaRepository pessoaRepository;
    private String id;

    // Buscar todos
    public List<CarroDTO> findAll(){
    List<Carro> listaCarro = carroRepository.findAll();
    return listaCarro.stream().map(CarroDTO::new).toList();
    }


    // Buscar por ID
    public CarroDTO findById(Long id) {
    Carro carro = carroRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com ID: " + id));
    return new CarroDTO(carro);
    }

}

package com.cefet.prova_20223006773.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.prova_20223006773.repositories.CarroRepository;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    /*// Buscar todos
    public List<CarroDTO> findAll(){
    List<Carro> listaCarro = carroRepository.findAll();
    return listaCarro.stream().map(CarroDTO::new).toList();
    }

    // Buscar por ID
    public CarroDTO findById(Long id) {
    Carro carro = carroRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Tipo não encontrado com ID: " + id));
    return new CarroDTO(carro);
    }

    // Inserir Tipo
    public CarroDTO insert(CarroDTO carroDTO) {
    Carro carro = new Carro();
    carro.setPessoa(carroDTO.getPessoa());
    Pessoa p = n
    carro.setPessoa(pessoa);
    Carro carroSalvo = carroRepository.save(carro);
    return new CarroDTO(carroSalvo);
    }

    // Atualizar Tipo
    public TipoDTO update(Long id, TipoDTO tipoDTO) {
    Tipo tipo = tipoRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Tipo não encontrado com ID: " + id));
    tipo.setDescricao(tipoDTO.getDescricao());
    Tipo tipoAtualizado = tipoRepository.save(tipo);
    return new TipoDTO(tipoAtualizado);
    }*/

}

package com.cefet.prova_20223006773.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.prova_20223006773.dto.CarroDTO;
import com.cefet.prova_20223006773.entities.Carro;
import com.cefet.prova_20223006773.entities.Pessoa;
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

    //cadastrar novo carro
    public CarroDTO insert(CarroDTO carroDTO) {
    Pessoa pessoa = pessoaRepository.findByCpf(carroDTO.getCpfPessoa())
        .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com CPF: " + carroDTO.getCpfPessoa()));
    if (carroRepository.existsByPlaca(carroDTO.getPlaca())) {
        throw new IllegalArgumentException("Placa já cadastrada");
    }
    Carro carro = new Carro();
    carro.setPlaca(carroDTO.getPlaca());
    carro.setPessoa(pessoa);
    Carro carroSalvo = carroRepository.save(carro);
    return new CarroDTO(carroSalvo);
    }


    /*// atualizar carro  
    public CarroDTO update(Long id, CarroDTO carroDTO) { 
        Carro carro = carroRepository.findById(id) 
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com ID: " + id)); 
        carro.setPlaca(carroDTO.getPlaca()); 
        produto.setDescricao(produtoDTO.getDescricao()); 
        produto.setPreco(produtoDTO.getPreco()); 
        produto.setEstoque(produtoDTO.getEstoque()); 
        produto.setTipo(produtoDTO.getTipo());         
        Carro carroAtualizado = carroRepository.save(carro); 
    }*/


    public CarroDTO update(Long id, CarroDTO carroDTO) {
    Carro carro = carroRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com ID: " + id));
    if (!carro.getPlaca().equals(carroDTO.getPlaca())) {
        if (carroRepository.existsByPlaca(carroDTO.getPlaca())) {
            throw new IllegalArgumentException("Placa já cadastrada");
        }
        carro.setPlaca(carroDTO.getPlaca());
    }
    if (!carro.getPessoa().getCpf().equals(carroDTO.getCpfPessoa())) {
        Pessoa novaPessoa = pessoaRepository.findByCpf(carroDTO.getCpfPessoa())
            .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com CPF: " + carroDTO.getCpfPessoa()));
        carro.setPessoa(novaPessoa);
    }

    Carro carroAtualizado = carroRepository.save(carro);
    return new CarroDTO(carroAtualizado);
    }

    //deletar carro
    public void delete(Long id) {
    Carro carro = carroRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com ID: " + id));
    carroRepository.delete(carro);
}

}
